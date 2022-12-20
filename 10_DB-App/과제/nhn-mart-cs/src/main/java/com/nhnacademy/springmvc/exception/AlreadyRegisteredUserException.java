package com.nhnacademy.springmvc.exception;

public class AlreadyRegisteredUserException extends RuntimeException {
    private final ErrorCode errorCode = ErrorCode.ALREADY_REGISTERED_USER;

    public AlreadyRegisteredUserException(String id) {
        super();
    }


}
