package com.experiment.mongoexample.exception;

public class UserExceptionHandler extends RuntimeException {
    public UserExceptionHandler(String message) {
        super(message);
    }
}
