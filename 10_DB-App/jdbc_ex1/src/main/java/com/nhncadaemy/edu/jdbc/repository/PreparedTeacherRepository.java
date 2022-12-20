package com.nhncadaemy.edu.jdbc.repository;

import com.nhncadaemy.edu.jdbc.domain.Teacher;
import com.nhncadaemy.edu.jdbc.domain.TeacherRepository;
import com.nhncadaemy.edu.jdbc.utils.DBUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PreparedTeacherRepository implements TeacherRepository {
    DataSource dataSource = DBUtils.getDataSource();

    @Override
    public List<Teacher> findAll(Connection connection) {
        String sql = "SELECT * FROM JdbcTeachers";
        List<Teacher> teachers = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                teachers.add(new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTime("created_at")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teachers;
    }

    @Override
    public Teacher findById(Connection connection, Long id) {
        String sql = "SELECT * FROM JdbcTeachers WHERE id = ?";
        Teacher teacher = null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                teacher = new Teacher(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTime("created_at"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacher;
    }

    //updateNameById, insert, deleteById
    @Override
    public void insertTeacher(Connection connection, Teacher teacher) throws SQLException {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO JdbcTeachers (id, name, created_at) VALUES (?, ?, ?)");
            statement.setLong(1, teacher.getId());
            statement.setString(2, teacher.getName());
            statement.setTimestamp(3, (Timestamp) teacher.getCreatedAt());

            int rowCount = statement.executeUpdate();
            System.out.println("insert count : " + rowCount);

        } catch (Exception e) {
            throw new SQLException();
        }
    }

    @Override
    public void updateTeacherNameById(Connection connection, Long id, String name) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE JdbcTeachers SET name = ? WHERE id = ?");
            statement.setString(1, name);
            statement.setLong(2, id);
            int rowCount = statement.executeUpdate();
            System.out.println("update count : " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTeacherById(Connection connection, Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM JdbcTeachers WHERE id = ?");
            statement.setLong(1, id);

            int rowCount = statement.executeUpdate();
            System.out.println("delete count : " + rowCount);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
