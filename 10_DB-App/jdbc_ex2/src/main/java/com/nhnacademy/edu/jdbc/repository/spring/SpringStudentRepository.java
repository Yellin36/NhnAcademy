package com.nhnacademy.edu.jdbc.repository.spring;

import com.nhnacademy.edu.jdbc.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpringStudentRepository {
    Student findById(long id);

    List<Student> findAll();

    int insert(Student student);

    int deleteById(long id);
}
