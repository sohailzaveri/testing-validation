package com.learn.validation.testingvalidation.controller;

import com.learn.validation.testingvalidation.model.Book;
import com.learn.validation.testingvalidation.model.BookRequest;
import com.learn.validation.testingvalidation.model.BookResponse;
import com.learn.validation.testingvalidation.service.BookService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookResponse> registerBook(
            @Valid @RequestBody BookRequest bookRequest) {

        logger.info("Received Request for registerBook with book: {}", bookRequest);

        BookResponse response =
                new BookResponse(bookService.registerBook(bookRequest.getBook()));

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(bookRequest.getBook().getId()).toUri();

        return ResponseEntity.status(HttpStatus.CREATED).location(location).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<Book>> retrieveBooks(@PageableDefault(size = 5) Pageable size){

        return ResponseEntity.status(200).body(bookService.retrieveAllBooks(size));

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> retrieveBookById(@PathVariable Long id) {

        return ResponseEntity.status(200)
                .body(
                        new BookResponse(bookService.retrieveBookById(id))
                );

    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBookById(
            @PathVariable Long id,
            @RequestBody BookRequest bookRequest
    ) {

        return ResponseEntity.status(200)
                .body(
                        new BookResponse(bookService.updateBook(id, bookRequest.getBook()))
                );

    }

}
