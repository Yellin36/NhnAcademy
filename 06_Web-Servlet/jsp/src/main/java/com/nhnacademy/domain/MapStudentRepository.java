package com.nhnacademy.domain;

import java.util.HashMap;
import java.util.Map;

public class MapStudentRepository implements StudentRepository {
    private Map<String, Student> map = new HashMap<>();

    @Override
    public void addStudent(Student student) {
        map.put(student.getId(), student);
    }

    @Override
    public Student getStudent(String id) {
        return map.get(id);
    }
}
