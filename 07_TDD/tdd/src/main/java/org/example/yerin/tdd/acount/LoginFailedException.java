package org.example.yerin.tdd.acount;

public class LoginFailedException extends RuntimeException{
    public LoginFailedException(String userName) {
        super("Login failed. userName=" + userName);
    }
}
