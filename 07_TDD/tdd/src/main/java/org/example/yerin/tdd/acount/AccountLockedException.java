package org.example.yerin.tdd.acount;

public class AccountLockedException extends RuntimeException {
    public AccountLockedException(String username) {
        super("Account is locked. username=" + username);
    }
}
