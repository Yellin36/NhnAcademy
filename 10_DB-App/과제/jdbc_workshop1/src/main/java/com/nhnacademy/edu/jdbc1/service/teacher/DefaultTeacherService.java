package com.nhnacademy.edu.jdbc1.service.teacher;

import com.nhnacademy.edu.jdbc1.domain.Teacher;
import org.springframework.stereotype.Service;

@Service
public class DefaultTeacherService implements TeacherService {
    private final TeacherRepository teacherRepository;

    public DefaultTeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(String teacherName) {
        int id = teacherRepository.insert(teacherName);

        Teacher teacher = teacherRepository.findById(id);
        return teacher;
    }

    @Override
    public Teacher modifyNameById(int id, String name) {
        teacherRepository.updateNameById(id, name);

        return teacherRepository.findById(id);
    }

    @Override
    public void deleteTeacher(int id) {
        teacherRepository.deleteById(id);
    }


}
