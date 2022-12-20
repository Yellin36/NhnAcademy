package com.nhncadaemy.edu.jdbc.domain;

import java.sql.Connection;
import java.sql.SQLException;

public interface SubjectRepository {
    void insert(Connection connection, Subject subject) throws SQLException;
    Subject findById(Connection connection, Long id) throws SQLException;

    void deleteById(Connection connection, Long id) throws SQLException;
}
