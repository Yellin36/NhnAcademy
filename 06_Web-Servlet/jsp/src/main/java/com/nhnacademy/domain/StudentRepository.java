package com.nhnacademy.domain;

public interface StudentRepository {
    void addStudent(Student student);
    Student getStudent(String id);
}
