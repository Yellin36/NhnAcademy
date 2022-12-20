package com.nhncadaemy.edu.jdbc.repository;

import com.nhncadaemy.edu.jdbc.domain.Teacher;
import com.nhncadaemy.edu.jdbc.domain.TeacherRepository;
import com.nhncadaemy.edu.jdbc.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcTeacherRepository implements TeacherRepository {
    @Override
    public List<Teacher> findAll(Connection connection) {
        List<Teacher> result = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM JdbcTeachers;");

            while (rs.next()) {
                result.add(new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTime("created_at")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Teacher findById(Connection connection, Long id) {
        Teacher teacher = null;
        try(Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM JdbcTeachers WHERE id = " + id);
            if(rs.next()) {
                teacher = new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTime("created_at")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return teacher;
    }

    @Override
    public void insertTeacher(Connection connection, Teacher teacher) {
        try (Statement statement = connection.createStatement()) {

            int rowCount = statement.executeUpdate("INSERT INTO JdbcTeachers VALUES (" +
                    teacher.getId() + ", " +
                    "\'" + teacher.getName() + "\', " +
                    teacher.getCreatedAt() + ")");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateTeacherNameById(Connection connection, Long id, String name) {
        try (Statement statement = connection.createStatement()) {

            int rowCount = statement.executeUpdate("UPDATE JdbcTeachers SET name = " + name + " WHERE id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteTeacherById(Connection connection, Long id) {
        try (Statement statement = connection.createStatement()) {

            int rowCount = statement.executeUpdate("DELETE FROM JdbcTeachers WHERE id = " + id);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
