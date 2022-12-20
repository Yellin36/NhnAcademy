package com.nhnacademy.edu.jdbc.repository;

import com.nhnacademy.edu.jdbc.domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PsmtRegistrationRepository implements RegistrationRepository {
    @Override
    public List<Registration> findAll(Connection connection) {
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT r.id, r.score, r.created_at, " +
                        "c.id as c_id, c.created_at as c_created_at, " +
                        "t.id as t_id, t.name as t_name, t.created_at as t_created_at, " +
                        "s.id as s_id, s.name AS s_name, s.created_at as s_created_at, " +
                        "st.id as st_id, st.name AS st_name, st.created_at as st_created_at " +
                        "FROM JdbcRegistrations r " +
                        "INNER JOIN JdbcCourses c ON r.course_id = c.id " +
                        "INNER JOIN JdbcStudents st On r.student_id = st.id " +
                        "INNER JOIN JdbcTeachers t ON c.teacher_id = t.id " +
                        "INNER JOIN JdbcSubjects s ON c.subject_id = s.id ")) {
            ResultSet rs = statement.executeQuery();

            List<Registration> registrations = new ArrayList<>();
            while (rs.next()) {
                registrations.add(new Registration(
                        rs.getLong("id"),
                        new Course(
                                rs.getLong("c_id"),
                                new Subject(
                                        rs.getLong("s_id"),
                                        rs.getString("s_name"),
                                        rs.getTimestamp("s_created_at")),
                                new Teacher(
                                        rs.getLong("t_id"),
                                        rs.getString("t_name"),
                                        rs.getTimestamp("t_created_at")),
                                rs.getTimestamp("c_created_at")),
                        new Student(
                                rs.getLong("st_id"),
                                rs.getString("st_name"),
                                rs.getTimestamp("st_created_at")),
                        rs.getLong("score"),
                        rs.getTimestamp("created_at"))
                );
            }
            return registrations;


        } catch (SQLException e) {

        }
        return null;
    }
}
