package com.learn.validation.testingvalidation.service;

import com.learn.validation.testingvalidation.exception.IllegalBookFieldException;
import com.learn.validation.testingvalidation.exception.RegisterBookException;
import com.learn.validation.testingvalidation.exception.ResourceNotFoundException;
import com.learn.validation.testingvalidation.model.Book;
import com.learn.validation.testingvalidation.repository.BookRepository;
import com.learn.validation.testingvalidation.utils.BookValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private BookRepository bookRepository;
    private BookValidator validator;

    public BookServiceImpl(BookRepository repository, BookValidator validator){
        this.bookRepository = repository;
        this.validator = validator;
    }

    @Override
    public Book retrieveBookById(Long id){

        Optional<Book> optionalBook = bookRepository.findById(id);

        if(optionalBook.isEmpty()) {
            throw new ResourceNotFoundException("No such book exists.");
        }

        return optionalBook.get();

    }

    @Override
    public Book registerBook(Book book) {

        if (!validator.test(book)) {
            throw new RegisterBookException("Failed to register book because invalid fields.");
        }

        boolean isBookFound =
                bookRepository.findBookByNameAndAuthor(book.getName(), book.getAuthor())
                        .isPresent();

        if(isBookFound) {
            throw new IllegalStateException("Book already exists.");
        }

        return bookRepository.save(book);

    }

    @Override
    public Page<Book> retrieveAllBooks(Pageable size){
        return bookRepository.findAll(size);
    }

    @Override
    public Book updateBook(Long id, Book book) {

        if(book.getId() != null && !Objects.equals(book.getId(), id)) {
            throw new IllegalStateException("Id's mismatch.");
        }

        if(book.getId() == null) book.setId(id);

        Book updatedBook = bookRepository.save(book);

        return book;

    }

}
