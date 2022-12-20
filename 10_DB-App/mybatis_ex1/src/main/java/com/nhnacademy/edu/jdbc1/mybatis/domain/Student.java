package com.nhnacademy.edu.jdbc1.mybatis.domain;

import java.util.Date;

public class Student {
    private final int id;
    private final String name;
    private final Date created_at;

    public Student(int id, String name, Date created_at) {
        this.id = id;
        this.name = name;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreated_at() {
        return created_at;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
