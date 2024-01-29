package com.learn.validation.testingvalidation.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookExceptionHandler {

    private static final String BAD_REQUEST_CODE = "BOOK400";
    private static final String BAD_REQUEST_MESSAGE = "Bad Request";

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleException(MethodArgumentNotValidException ex){

        logger.error("Invalid arguments passed as fields of input", ex);

        return ResponseEntity.status(400).body(
                new Error(BAD_REQUEST_CODE, BAD_REQUEST_MESSAGE,
                        "Invalid arguments passed in the request body.",
                        ""
                        )
        );
    }

    @ExceptionHandler(RegisterBookException.class)
    public ResponseEntity<Error> handleException(RegisterBookException ex) {

        logger.error("Failed to register book. ", ex);

        return ResponseEntity.status(400).body(
                new Error(BAD_REQUEST_CODE, BAD_REQUEST_MESSAGE,
                        ex.getMessage(),
                        "")
        );

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(Exception ex) {
        logger.error("Some exception occurred. ", ex);
        return ResponseEntity.status(500).body(
                new Error(BAD_REQUEST_CODE, BAD_REQUEST_MESSAGE,
                        ex.getMessage(),
                        "")
        );
    }

}
