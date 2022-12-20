package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.Page;
import com.nhnacademy.edu.jdbc.domain.Student;
import com.nhnacademy.edu.jdbc.domain.Teacher;

import java.sql.Connection;
import java.sql.SQLException;

public interface TeacherRepository {
    void insert(Connection connection, Teacher teacher) throws SQLException;

    Page<Teacher> findAll(Connection connection, int page, int size) throws SQLException;
}
