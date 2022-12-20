package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.User;
import com.nhnacademy.edu.jdbc1.service.login.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class JdbcTemplateUserRepository implements UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int insert(User user) {
        return this.jdbcTemplate.update(
                "INSERT INTO JdbcUsers VALUES (?, ?, ?, ?)",
                user.getId(),
                user.getUserName(),
                user.getPassword(),
                user.getCreatedAt());
    }

    @Override
    public User findById(int id) {
        return this.jdbcTemplate.queryForObject(
                "SELECT id, username, password, created_at FROM JdbcUsers WHERE id = ?",
                (rs, rowCount) -> new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at")
                ),
                id);
    }

    @Override
    public User findByUserName(String username) {
        return this.jdbcTemplate.queryForObject(
                "SELECT id, username, password, created_at FROM JdbcUsers WHERE username = ?",
                (rs, rowCount) -> new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getTimestamp("created_at")
                ),
                username);
    }
}
