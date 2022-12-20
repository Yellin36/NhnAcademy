package com.nhncadaemy.edu.jdbc.domain;


import java.util.Date;

public class Course {
    private final int id;
    private final int teacherId;
    private final int subjectId;
    private final Date createdAt;

    public Course(int id, int teacherId, int subjectId, Date createdAt) {
        this.id = id;
        this.teacherId = teacherId;
        this.subjectId = subjectId;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
