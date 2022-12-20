package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    private final String id;
    @Setter
    private String password;
    @Setter
    private String name;

    public User(String id, String password, String name) {
        this.id = id;
        this.password = password;
        this.name = name;
    }
}
