package com.iris.bookstore_api.serviceImpl;

import com.iris.bookstore_api.model.Book;
import com.iris.bookstore_api.repository.BookStoreRepository;
import com.iris.bookstore_api.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookStoreServiceImpl implements BookStoreService {
    @Autowired
    private BookStoreRepository bookStoreRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookStoreRepository.findAll();
    }

    @Override
    public Book getBookByBookId(String bookId) {
       return bookStoreRepository.findById(bookId).get();
    }

    @Override
    public void saveBook(Book book) {
        bookStoreRepository.save(book);
    }

    @Override
    public void updateBook(String id, Book book) {
       bookStoreRepository.save(book);
    }

    @Override
    public void deleteBook(String id) {
        bookStoreRepository.deleteById(id);

    }
}
