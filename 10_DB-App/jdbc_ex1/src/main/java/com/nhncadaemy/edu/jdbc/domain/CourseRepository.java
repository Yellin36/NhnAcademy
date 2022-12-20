package com.nhncadaemy.edu.jdbc.domain;

import java.sql.Connection;
import java.sql.SQLException;

public interface CourseRepository {
    void insert(Connection connection, Course course) throws SQLException;
    Course findById(Connection connection, Long id) throws SQLException;
    void deleteById(Connection connection, Long id) throws SQLException;
}
