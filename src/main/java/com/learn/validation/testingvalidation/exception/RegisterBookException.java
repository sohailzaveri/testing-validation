package com.learn.validation.testingvalidation.exception;

public class RegisterBookException extends RuntimeException {

    public RegisterBookException(String message, Exception ex) {
        super(message, ex);
    }

    public RegisterBookException(String message) {
        super(message);
    }

}
