package com.nhncadaemy.edu.jdbc.domain;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface TeacherRepository {
    List<Teacher> findAll(Connection connection);
    Teacher findById(Connection connection, Long id);
    void insertTeacher(Connection connection, Teacher teacher) throws SQLException;
    void updateTeacherNameById(Connection connection, Long id, String name);
    void deleteTeacherById(Connection connection, Long id);
}
