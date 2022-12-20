package com.nhnacademy.edu.jdbc.service;

import com.nhnacademy.edu.jdbc.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student getStudent(long id);

    List<Student> getAllStudents();

    void insertAndDelete(Student student);

    void insertAndDeleteWithoutTransaction(Student student);
}
