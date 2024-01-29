package com.learn.validation.testingvalidation.utils;

import com.learn.validation.testingvalidation.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookValidator {

    public boolean test(Book book) {
        return book.getAuthor().length() < 10
                && book.getDescription().length() < 20;
    }

}
