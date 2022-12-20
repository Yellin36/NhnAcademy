package com.nhnacademy.jdbc.board.exception;

public class LoginFailedException extends RuntimeException {
    public LoginFailedException(String password) {
        super("Incorrect Password : " + password);
    }
}
