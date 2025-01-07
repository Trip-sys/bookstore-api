package com.iris.bookstore_api.mapper;

import com.iris.bookstore_api.DTO.BookDTO;
import com.iris.bookstore_api.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {


    public BookDTO toBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setPrice(book.getPrice());
        return bookDTO;
    }
   public  Book toBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setBookId(bookDTO.getBookId());
        book.setAuthor(bookDTO.getAuthor());
        book.setTitle(bookDTO.getTitle());
        book.setPrice(bookDTO.getPrice());
        return book;
    }
}
