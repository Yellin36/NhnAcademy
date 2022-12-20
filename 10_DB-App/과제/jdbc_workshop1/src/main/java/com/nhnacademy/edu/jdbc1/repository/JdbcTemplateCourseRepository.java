package com.nhnacademy.edu.jdbc1.repository;

import com.nhnacademy.edu.jdbc1.domain.Course;
import com.nhnacademy.edu.jdbc1.domain.Subject;
import com.nhnacademy.edu.jdbc1.domain.Teacher;
import com.nhnacademy.edu.jdbc1.service.course.CourseRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcTemplateCourseRepository implements CourseRepository {
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateCourseRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int insert(Course course) {
        return this.jdbcTemplate.update(
                "INSERT INTO JdbcCourses(teacher_id, subject_id, created_at) VALUES (?, ?, ?)",
                course.getTeacher().getId(),
                course.getSubject().getId(),
                course.getCreatedAt()
        );
    }

    @Override
    public List<Course> findAll() {
        return this.jdbcTemplate.query(
                "SELECT c.id, c.created_at, " +
                        "t.id as t_id, t.name as t_name, t.created_at as t_created_at, " +
                        "s.id as s_id, s.name as s_name, s.created_at as s_created_at " +
                        "FROM JdbcCourses c " +
                        "INNER JOIN JdbcTeachers t ON c.teacher_id = t.id " +
                        "INNER JOIN JdbcSubjects s On c.subject_id = s.id",
                (rs, rowNum) -> new Course(
                        rs.getInt("id"),
                        new Teacher(
                                rs.getInt("t_id"),
                                rs.getString("t_name"),
                                rs.getTimestamp("t_created_at")),
                        new Subject(
                                rs.getInt("s_id"),
                                rs.getString("s_name"),
                                rs.getTimestamp("s_created_at")),
                        rs.getTimestamp("created_at")));
    }

    @Override
    public Course findById(int id) {
        return this.jdbcTemplate.queryForObject(
                "SELECT c.id, c.created_at, " +
                        "t.id as t_id, t.name as t_name, t.created_at as t_created_at, " +
                        "s.id as s_id, s.name as s_name, s.created_at as s_created_at " +
                        "FROM JdbcCourses c " +
                        "INNER JOIN JdbcTeachers t ON c.teacher_id = t.id " +
                        "INNER JOIN JdbcSubjects s On c.subject_id = s.id " +
                        "WHERE c.id = ?",
                (rs, rowNum) -> new Course(
                        rs.getInt("id"),
                        new Teacher(
                                rs.getInt("t_id"),
                                rs.getString("t_name"),
                                rs.getTimestamp("t_created_at")),
                        new Subject(
                                rs.getInt("s_id"),
                                rs.getString("s_name"),
                                rs.getTimestamp("s_created_at")),
                        rs.getTimestamp("created_at")), id);
    }

    @Override
    public int updateSubjectIdById(int id, int subjectId) {
        return this.jdbcTemplate.update(
                "UPDATE JdbcCourses SET subject_id = ? WHERE id = ?",
                subjectId, id);
    }

    @Override
    public int updateTeacherIdById(int id, int teacherId) {
        return this.jdbcTemplate.update(
                "UPDATE JdbcCourses SET teacher_id = ? WHERE id = ?",
                teacherId, id);
    }

    @Override
    public int deleteById(int id) {
        return this.jdbcTemplate.update(
                "DELETE FROM JdbcCourses WHERE id = ?", id
        );
    }
}
