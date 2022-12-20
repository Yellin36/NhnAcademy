package com.nhnacademy.edu.jdbc.repository.spring;

import com.nhnacademy.edu.jdbc.domain.Teacher;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcTemplateTeacherRepository implements SpringTeacherRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTeacherRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Teacher findById(long id) {
        return this.jdbcTemplate.queryForObject(
                "SELECT * FROM JdbcTeachers WHERE id = ?",
                (rs, rowCount) -> new Teacher(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at")
                ), id
        );
    }

    @Override
    public List<Teacher> findAll() {
        return this.jdbcTemplate.query(
                "SELECT * FROM JdbcTeachers",
                (rs, rowCount) -> new Teacher(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getTimestamp("created_at")
                )
        );
    }

    @Override
    public int insert(Teacher teacher) {
        return this.jdbcTemplate.update(
                "INSERT INTO JdbcTeachers VALUES (?, ?, ?)",
                teacher.getId(),
                teacher.getName(),
                teacher.getCreatedAt()
        );
    }

    @Override
    public int deleteById(long id) {
        return this.jdbcTemplate.update(
                "DELETE FROM JdbcTeachers WHERE id = ?",
                id
        );
    }
}
