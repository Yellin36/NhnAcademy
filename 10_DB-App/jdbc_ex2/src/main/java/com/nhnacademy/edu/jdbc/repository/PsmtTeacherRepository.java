package com.nhnacademy.edu.jdbc.repository;

import com.mysql.cj.protocol.Resultset;
import com.nhnacademy.edu.jdbc.domain.Page;
import com.nhnacademy.edu.jdbc.domain.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PsmtTeacherRepository implements TeacherRepository {
    @Override
    public void insert(Connection connection, Teacher teacher) throws SQLException {
        try(connection) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO JdbcTeachers VALUES (?, ?, ?)");
            statement.setLong(1, teacher.getId());
            statement.setString(2, teacher.getName());
            statement.setTimestamp(3, (Timestamp) teacher.getCreatedAt());

            statement.executeUpdate();
        }
    }

    @Override
    public Page<Teacher> findAll(Connection connection, int page, int size) throws SQLException {
        long totalCount = 0;
        List<Teacher> teacherList = new ArrayList<>();

        try(connection) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM JdbcTeachers ORDER BY id LIMIT ? OFFSET ?");
            statement.setInt(1, size);
            statement.setInt(2, (page - 1) * size);

            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                teacherList.add( new Teacher(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at")));
            }
            PreparedStatement statement1 = connection.prepareStatement("SELECT COUNT(*) as count FROM JdbcTeachers");
            ResultSet rs1 = statement1.executeQuery();

            if(rs1.next()) {
                totalCount = rs1.getInt("count");
            }
        }
        return new Page<>(teacherList, totalCount);
    }
}
