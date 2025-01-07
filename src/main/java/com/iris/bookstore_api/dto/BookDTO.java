package com.iris.bookstore_api.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;


@Component
public class BookDTO {
    @NotBlank(message = "Book ID cannot be null or blank")
    private String bookId;
    private String title;
    private String author;
    @Min(value = 0, message = "Book Price cannot be negative")
    private long price;

    public BookDTO() {
    }

    public BookDTO(String bookId, String title, String author, long price) {
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
