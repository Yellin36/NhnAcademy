package com.nhnacademy.edu.jdbc.service;

import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.repository.spring.SpringTeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultTeacherService implements TeacherService {
    private final SpringTeacherRepository teacherRepository;

    public DefaultTeacherService(SpringTeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher getTeacher(long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    @Transactional
    public void insertAndDelete(Teacher teacher) {
        teacherRepository.insert(teacher);
        teacherRepository.deleteById(teacher.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Teacher teacher) {
        teacherRepository.insert(teacher);
        teacherRepository.deleteById(teacher.getId());
    }



}
