package org.example.yerin.tdd.acount;

public class Account {
    private Long id;
    private String username;
    private String password;
    private boolean locked;
    private int wrongCount;
    private final int LIMIT_FAIL_COUNT = 3;
    private final int LOGIN_FAIL_LOCKED_LIMIT = 3;

    public Account(String username, String password) {
        this.id = nextUuid();
        this.username = username;
        this.password = password;
    }
    public boolean isLocked() {
        return this.wrongCount >= LIMIT_FAIL_COUNT;
    }
    public boolean getLock() {
        return this.locked;
    }
    public void successLogin() {
        this.wrongCount = 0;
    }
    public void unLock() {
        this.locked = false;
        this.wrongCount = 0;
    }
    public void failLogin() {
        this.wrongCount++;
    }
    public void increaseWrongCount() {
        this.wrongCount++;

        if(wrongCount == 3) {
            this.locked = true;
        }
    }
    public void initWrongCount() {
        this.wrongCount = 0;
    }

    private static long nextUuid() {
        // Generate Id
        return System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean matchPassword(String password) {
        return false;
    }
}
