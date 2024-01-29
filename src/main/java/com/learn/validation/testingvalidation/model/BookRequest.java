package com.learn.validation.testingvalidation.model;

import jakarta.validation.Valid;

public class BookRequest {

    @Valid
    private Book book;

    public BookRequest(Book book) {
        this.book = book;
    }

    public BookRequest(){

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
