package com.iris.bookstore_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private String bookId;
    private String title;
    private String author;
    private long price;


    public Book() {

    }
    public Book(String bookId, String title, String author, long price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
