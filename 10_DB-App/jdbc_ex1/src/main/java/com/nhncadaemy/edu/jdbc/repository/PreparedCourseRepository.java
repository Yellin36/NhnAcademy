package com.nhncadaemy.edu.jdbc.repository;

import com.nhncadaemy.edu.jdbc.domain.*;

import java.sql.*;

public class PreparedCourseRepository implements CourseRepository {
    @Override
    public void insert(Connection connection, Course course) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO JdbcCourses VALUES (?, ?, ?, ?)");
            statement.setInt(1, course.getId());
            statement.setInt(2, course.getTeacherId());
            statement.setInt(3, course.getSubjectId());
            statement.setTimestamp(4, (Timestamp) course.getCreatedAt());

            int rowCount = statement.executeUpdate();

            System.out.println("insert count : " + rowCount);
        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public Course findById(Connection connection, Long id) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM JdbcCourses WHERE id = ?");
            statement.setLong(1, id);

            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                return new Course(rs.getInt("id"),
                        rs.getInt("teacher_id"),
                        rs.getInt("subject_id"),
                        rs.getTimestamp("created_at"));
            }
        } catch (Exception e) {
            connection.rollback();
        }
        return null;
    }

    @Override
    public void deleteById(Connection connection, Long id) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM JdbcCourses WHERE id = ?");
            statement.setLong(1, id);

            int rowCount = statement.executeUpdate();

            System.out.println("delete count : " + rowCount);
        } catch (Exception e) {
            connection.rollback();
        }
    }
}
