package com.nhnacademy.springmvc.exception;

public class InvalidAuthorAccessException extends RuntimeException {
    public InvalidAuthorAccessException(String option) {
        super(option);
    }
}
