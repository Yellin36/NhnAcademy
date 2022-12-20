package com.nhnacademy.edu.jdbc1.domain;

import lombok.Getter;

import java.util.Date;

@Getter
public class User {
    private final int id;
    private String userName;
    private String password;
    private final Date createdAt;

    public User(int id, String userName, String password, Date createdAt) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", userName='" + userName + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
