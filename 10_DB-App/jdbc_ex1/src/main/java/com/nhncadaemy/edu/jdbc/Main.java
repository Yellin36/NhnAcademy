package com.nhncadaemy.edu.jdbc;

import com.nhncadaemy.edu.jdbc.domain.Course;
import com.nhncadaemy.edu.jdbc.domain.Subject;
import com.nhncadaemy.edu.jdbc.domain.Teacher;
import com.nhncadaemy.edu.jdbc.repository.JdbcTeacherRepository;
import com.nhncadaemy.edu.jdbc.repository.PreparedCourseRepository;
import com.nhncadaemy.edu.jdbc.repository.PreparedSubjectRepository;
import com.nhncadaemy.edu.jdbc.repository.PreparedTeacherRepository;
import com.nhncadaemy.edu.jdbc.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import static com.nhncadaemy.edu.jdbc.utils.DBUtils.loadDriver;

public class Main {
    public static void main(String[] args) {
        loadDriver();
        System.out.println("jdbc is connected!");

        try (Connection connection = DBUtils.getDataSource().getConnection()) {
//            sql_ex1(connection);
            sql_practice1(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sql_ex1(Connection connection) throws SQLException {
        JdbcTeacherRepository jdbcTeacherRepository = new JdbcTeacherRepository();

        List<Teacher> teachers = jdbcTeacherRepository.findAll(connection);
        System.out.println(teachers);

        Teacher teacher = jdbcTeacherRepository.findById(connection, 1L);
        System.out.println(teacher);

        PreparedTeacherRepository teacherRepository = new PreparedTeacherRepository();

        List<Teacher> teachers1 = teacherRepository.findAll(connection);
        System.out.println(teachers1);

        Teacher teacher1 = teacherRepository.findById(connection, 1L);
        System.out.println(teacher1);

        teacherRepository.insertTeacher(connection, new Teacher(4, "콤틴", new Timestamp(new Date().getTime())));
        teacherRepository.findAll(connection).stream().forEach(System.out::println);
        teacherRepository.updateTeacherNameById(connection, 4L, "comptin");
        teacherRepository.findAll(connection).stream().forEach(System.out::println);
        teacherRepository.deleteTeacherById(connection, 4L);
        teacherRepository.findAll(connection).stream().forEach(System.out::println);
    }

    /* JdbcTeachers 에 "콤틴" 교수를 추가합니다.
JdbcSubjects 에 HTTP 과목을 추가합니다.
JdbcCourses 에 "콤틴" 교수가 진행하는 HTTP 과목 과정을 생성합니다.
이 모든 과정이 성공해야만 COMMIT 합니다.
이중 하나라도 에러가 나면 ROLLBACK 합니다. */
    private static void sql_practice1(Connection connection) throws SQLException{
        try {
            connection.setAutoCommit(false);

            PreparedTeacherRepository teacherRepository = new PreparedTeacherRepository();
            PreparedCourseRepository courseRepository = new PreparedCourseRepository();
            PreparedSubjectRepository subjectRepository = new PreparedSubjectRepository();

            Teacher teacher = new Teacher(1, "콤틴", new Timestamp(new Date().getTime()));
            Subject subject = new Subject(2, "HTTP", new Timestamp(new Date().getTime()));
            Course course = new Course(3, 55, 55, new Timestamp(new Date().getTime()));

            teacherRepository.insertTeacher(connection, teacher);
            subjectRepository.insert(connection, subject);
            courseRepository.insert(connection, course);

            connection.commit();
            System.out.println("commit success");
        } catch (SQLException e) {
            System.out.println("rollback!!");
            connection.rollback();
        }
    }

}