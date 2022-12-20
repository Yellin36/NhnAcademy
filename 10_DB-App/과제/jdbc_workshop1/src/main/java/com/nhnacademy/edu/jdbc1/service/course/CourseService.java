package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.domain.Course;
import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    void deleteCourse(int courseId);

    void insert(Course course);

    Course getCourseById(int courseId);

    void modify(int courseId, Teacher teacher, Subject subject);
}
