package com.nhnacademy.springmvc.exception;

public class InvalidPostAccessException extends RuntimeException {
    public InvalidPostAccessException(Long postId) {
        super(postId.toString());
    }
}
