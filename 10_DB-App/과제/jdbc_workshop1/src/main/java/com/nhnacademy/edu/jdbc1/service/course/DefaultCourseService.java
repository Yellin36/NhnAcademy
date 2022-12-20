package com.nhnacademy.edu.jdbc1.service.course;

import com.nhnacademy.edu.jdbc1.domain.Course;
import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;
import com.nhnacademy.edu.jdbc1.repository.JdbcTemplateCourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultCourseService implements CourseService {
    private final JdbcTemplateCourseRepository courseRepository;

    public DefaultCourseService(JdbcTemplateCourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourse(int courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    @Transactional
    public void insert(Course course) {
        courseRepository.insert(course);
    }


    @Override
    public Course getCourseById(int courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public void modify(int courseId, Teacher teacher, Subject subject) {
        courseRepository.updateSubjectIdById(courseId, subject.getId());
        courseRepository.updateTeacherIdById(courseId, teacher.getId());
    }
}
