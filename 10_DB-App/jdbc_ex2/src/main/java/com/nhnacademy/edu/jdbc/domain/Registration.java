package com.nhnacademy.edu.jdbc.domain;

import java.util.Date;

public class Registration {
    private final Long id;
    private final Course course;
    private final Student student;
    private final Long score;
    private final Date created_at;

    public Registration(Long id, Course course, Student student, Long score, Date created_at) {
        this.id = id;
        this.course = course;
        this.student = student;
        this.score = score;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public Student getStudent() {
        return student;
    }

    public Long getScore() {
        return score;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String toFormattedString() {
        return "Registration{" +
                "id=" + id +
                ", course_teacher_name=" + course.getTeacher().getName() +
                ", course_subject_name=" + course.getSubject().getName() +
                ", student_name=" + student.getName() +
                ", score=" + score +
                ", created_at=" + created_at +
                '}';
    }
}
