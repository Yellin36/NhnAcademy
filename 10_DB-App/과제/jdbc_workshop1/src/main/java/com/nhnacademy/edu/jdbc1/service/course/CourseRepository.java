package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.domain.Course;

import java.util.List;

public interface CourseRepository {
    int insert(Course course);

    List<Course> findAll();

    Course findById(int id);

    int updateSubjectIdById(int id, int subjectId);

    int updateTeacherIdById(int id, int teacherId);

    int deleteById(int id);
}
