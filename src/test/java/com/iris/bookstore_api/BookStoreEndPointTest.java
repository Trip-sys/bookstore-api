package com.iris.bookstore_api;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iris.bookstore_api.DTO.BookDTO;
import com.iris.bookstore_api.mapper.BookMapper;
import com.iris.bookstore_api.model.Book;
import com.iris.bookstore_api.service.BookStoreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class BookStoreEndPointTest {

    @Autowired(required = true)
    private MockMvc mockMvc;

    @MockitoBean
    private BookStoreService bookStoreService;

    @Mock
    private BookMapper bookMapper;

    @Autowired
    private ObjectMapper objectMapper;  // For converting objects to JSON

    private Book book;
    private BookDTO bookDTO;

    @BeforeEach
    void setUp() {
        // Initialize book and bookDTO objects for the tests
        book = new Book("123", "Test Book", "Author Name", 1200);
        bookDTO = new BookDTO("123", "Test Book", "Author Name", 1200);
        when(bookStoreService.getBookByBookId(anyString())).thenReturn(book);
        when(bookMapper.toBookDTO(any(Book.class))).thenReturn(bookDTO);
    }

    @Test
    void testGetBookFound() throws Exception {
        // Mock the behavior of bookStoreService
        Mockito.when(bookStoreService.getBookByBookId(ArgumentMatchers.anyString())).thenReturn(book);
        Mockito.when(bookMapper.toBookDTO(any(Book.class))).thenReturn(bookDTO);

        // Test the successful response (200 OK)
        mockMvc.perform(get("/books/{id}", "123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.bookId").value("123"))
                .andExpect(jsonPath("$.title").value("Test Book"))
                .andExpect(jsonPath("$.author").value("Author Name"))
                .andExpect(jsonPath("$.price").value(1200));

        // Verify interactions
        verify(bookStoreService, times(1)).getBookByBookId("123");
    }

    @Test
    void testGetBookNotFound() throws Exception {
        // Mock the behavior when the book is not found
        when(bookStoreService.getBookByBookId(anyString())).thenReturn(null);

        // Test the 404 response with the custom error message
        mockMvc.perform(get("/books/{id}", "123"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error").value("There is no Book in Book Store with BookId : 123"));

        // Verify interactions
        verify(bookStoreService, times(1)).getBookByBookId("123");
    }


}
