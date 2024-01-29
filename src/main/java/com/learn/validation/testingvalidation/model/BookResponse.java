package com.learn.validation.testingvalidation.model;

public class BookResponse {

    private final Book book;

    public BookResponse(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
