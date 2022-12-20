package com.nhnacademy.edu.jdbc.service;

import com.nhnacademy.edu.jdbc.domain.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    Teacher getTeacher(long id);

    List<Teacher> getAllTeachers();

    void insertAndDelete(Teacher teacher);

    void insertAndDeleteWithoutTransaction(Teacher teacher);
}
