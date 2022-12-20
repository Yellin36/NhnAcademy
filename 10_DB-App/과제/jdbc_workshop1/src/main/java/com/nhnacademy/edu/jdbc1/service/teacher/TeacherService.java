package com.nhnacademy.edu.jdbc1.service.teacher;

import com.nhnacademy.edu.jdbc1.domain.Teacher;

public interface TeacherService {
    Teacher createTeacher(String teacherName);

    Teacher modifyNameById(int id, String name);

    void deleteTeacher(int id);
}
