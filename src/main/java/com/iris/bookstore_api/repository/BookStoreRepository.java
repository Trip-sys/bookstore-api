package com.iris.bookstore_api.repository;

import com.iris.bookstore_api.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookStoreRepository extends JpaRepository<Book, String> {
}
