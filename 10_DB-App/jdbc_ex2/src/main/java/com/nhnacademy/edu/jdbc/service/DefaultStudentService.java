package com.nhnacademy.edu.jdbc.service;

import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.repository.spring.SpringStudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DefaultStudentService implements StudentService {
    private final SpringStudentRepository studentRepository;


    public DefaultStudentService(SpringStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudent(long id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public void insertAndDelete(Student student) {
        studentRepository.insert(student);
        studentRepository.deleteById(student.getId());
    }

    @Override
    public void insertAndDeleteWithoutTransaction(Student student) {
        studentRepository.insert(student);
        studentRepository.deleteById(student.getId());
    }
}
