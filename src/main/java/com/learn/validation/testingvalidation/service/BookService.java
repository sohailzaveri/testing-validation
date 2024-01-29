package com.learn.validation.testingvalidation.service;

import com.learn.validation.testingvalidation.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {

    Book retrieveBookById(Long id);
    Book registerBook(Book book);
    Page<Book> retrieveAllBooks(Pageable size);

    Book updateBook(Long id, Book book);

}
