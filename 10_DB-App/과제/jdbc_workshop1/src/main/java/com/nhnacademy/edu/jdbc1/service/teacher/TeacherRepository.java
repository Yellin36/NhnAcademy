package com.nhnacademy.edu.jdbc1.service.teacher;

import com.nhnacademy.edu.jdbc1.domain.Teacher;

public interface TeacherRepository {
    Teacher findById(int id);

    int insert(String teacher);

    int updateNameById(int id, String name);

    int deleteById(int id);
}
