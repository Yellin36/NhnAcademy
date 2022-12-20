package com.nhncadaemy.edu.jdbc.repository;

import com.nhncadaemy.edu.jdbc.domain.Course;
import com.nhncadaemy.edu.jdbc.domain.Subject;
import com.nhncadaemy.edu.jdbc.domain.SubjectRepository;

import java.sql.*;

public class PreparedSubjectRepository implements SubjectRepository {
    @Override
    public void insert(Connection connection, Subject subject) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO JdbcSubjects(id, name, created_at) VALUES (?, ?, ?)");
            statement.setInt(1, subject.getId());
            statement.setString(2, subject.getName());
            statement.setTimestamp(3, (Timestamp) subject.getCreatedAt());

            int rowCount = statement.executeUpdate();

            System.out.println("insert count : " + rowCount);

        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public void deleteById(Connection connection, Long id) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM JdbcSubjects WHERE id = ?");
            statement.setLong(1, id);

            int rowCount = statement.executeUpdate();

            System.out.println("delete count : " + rowCount);
        } catch (Exception e) {
            connection.rollback();
        }
    }

    @Override
    public Subject findById(Connection connection, Long id) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM JdbcSubjects WHERE id = ?");
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                return new Subject(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at"));
            }
        } catch (Exception e) {
            connection.rollback();
        }
        return null;
    }
}
