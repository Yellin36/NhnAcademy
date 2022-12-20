package com.nhnacademy.edu.jdbc1.domain;

import java.util.Date;

public class Subject {
    private final int id;
    private final String name;
    private final Date createdAt;

    public Subject(int id, String name, Date createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
