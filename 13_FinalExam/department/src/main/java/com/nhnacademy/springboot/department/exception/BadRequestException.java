package com.nhnacademy.springboot.department.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException() {
        super("Needs more than 1 Parameter or Set Accept Header 'application/json'");
    }

}
