package com.nhnacademy.edu.jdbc1.domain;


import lombok.Getter;

import java.util.Date;

@Getter
public class Course {
    private int id;
    private final Teacher teacher;
    private final Subject subject;
    private final Date createdAt;

    public Course(int id, Teacher teacher, Subject subject, Date createdAt) {
        this.id = id;
        this.teacher = teacher;
        this.subject = subject;
        this.createdAt = createdAt;
    }

    public Course(Teacher teacher, Subject subject, Date createdAt) {
        this.teacher = teacher;
        this.subject = subject;
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", teacher=" + teacher.getName() +
                ", subject=" + subject.getName() +
                ", createdAt=" + createdAt +
                '}';
    }
}

