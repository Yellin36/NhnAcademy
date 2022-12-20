package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.Teacher;
import com.nhnacademy.edu.jdbc1.service.teacher.TeacherRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

@Repository
public class JdbcTemplateTeacherRepository implements TeacherRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTeacherRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Teacher findById(int id) {
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM JdbcTeachers WHERE id = ?",
                (rs, rowCount) -> new Teacher(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at")
                ), id
        );
    }

    @Override
    public int insert(String teacher) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO JdbcTeachers(name, created_at) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, teacher);
            ps.setTimestamp(2, new Timestamp(new Date().getTime()));
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public int updateNameById(int id, String name) {
        return this.jdbcTemplate.update(
                "UPDATE JdbcTeachers SET name = ? WHERE id = ? ",
                name, id
        );
    }

    @Override
    public int deleteById(int id) {
        return this.jdbcTemplate.update(
                "DELETE FROM JdbcTeachers WHERE id = ?",
                id
        );
    }
}
