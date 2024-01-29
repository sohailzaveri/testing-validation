package com.learn.validation.testingvalidation.repository;

import com.learn.validation.testingvalidation.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByName(String name);

    Book findBookByAuthor(String author);

    Book findBookByAuthorAfter(String authorPrefix);

    Optional<Book> findBookByNameAndAuthor(String name, String author);

}
