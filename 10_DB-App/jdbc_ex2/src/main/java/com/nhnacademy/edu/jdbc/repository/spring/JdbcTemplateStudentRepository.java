package com.nhnacademy.edu.jdbc.repository.spring;

import com.nhnacademy.edu.jdbc.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcTemplateStudentRepository implements SpringStudentRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateStudentRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Student findById(long id) {
        return this.jdbcTemplate.queryForObject(
                "select id, name, created_at from JdbcStudents where id = ?",
                (rs, rowNum) ->
                        new Student(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getTimestamp("created_at")),
                id);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query(
                "select id, name, created_at from JdbcStudents",
                (resultSet, rowNum) ->
                        new Student(resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getTimestamp("created_at")));
    }

    @Override
    public int insert(Student student) {
        return jdbcTemplate.update(
                "INSERT INTO JdbcStudents(id, name, created_at) VALUES (?,?,?)",
                student.getId(),
                student.getName(),
                student.getCreatedAt()
        );
    }

    @Override
    public int deleteById(long id) {
        return jdbcTemplate.update(
                "DELETE FROM JdbcStudents WHERE id=?",
                id
        );
    }
}
