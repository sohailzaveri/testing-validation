package com.learn.validation.testingvalidation.exception;

public class Error {

    private String errorCode;
    private String errorName;
    private String message;
    private String description;

    public Error(String errorCode, String errorName, String message, String description) {
        this.errorCode = errorCode;
        this.errorName = errorName;
        this.message = message;
        this.description = description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
