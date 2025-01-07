package com.iris.bookstore_api.controller;

import com.iris.bookstore_api.dto.BookDTO;
import com.iris.bookstore_api.mapper.BookMapper;
import com.iris.bookstore_api.model.Book;
import com.iris.bookstore_api.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class BookStoreEndPoint {
    @Autowired
    private BookStoreService bookStoreService;
    @Autowired
    private BookMapper bookMapper;

    @GetMapping(value = "/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookStoreService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping(value = "/books/{id}")
    public ResponseEntity getBook(@PathVariable String id) {
        Book book = bookStoreService.getBookByBookId(id);

        if (Objects.isNull(book)) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "There is no Book in Book Store with BookId : " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        } else {
            return ResponseEntity.ok(bookMapper.toBookDTO(book));
        }
    }

    @PostMapping(value = "/books")
    public ResponseEntity<Void> saveBook(@Validated @RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
         bookStoreService.saveBook(book);

         return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }

    @PutMapping(value = "/books/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable String id, @Validated @RequestBody BookDTO bookDTO) {
        Book book = bookMapper.toBook(bookDTO);
         bookStoreService.updateBook(id, book);
        return ResponseEntity.status(HttpStatus.OK.value()).build();
    }

    @DeleteMapping(value = "/books/{id}")
    public ResponseEntity deleteBook(@PathVariable String id) {
         bookStoreService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

}
