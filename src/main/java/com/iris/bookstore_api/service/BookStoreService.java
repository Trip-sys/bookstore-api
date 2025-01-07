package com.iris.bookstore_api.service;

import com.iris.bookstore_api.model.Book;

import java.util.List;

public interface BookStoreService {
    List<Book> getAllBooks();

    Book getBookByBookId(String bookId);

    void saveBook(Book book);

    void updateBook(String id, Book book);

    void deleteBook(String id);

}
