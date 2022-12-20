package com.nhnacademy.edu.jdbc1.mybatis.mapper;

import com.nhnacademy.edu.jdbc1.mybatis.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;
import java.util.List;

public interface StudentMapper {
    @Select("SELECT * FROM JdbcStudents WHERE id = #{id}")
    Student selectStudent(int id);

    @Select("select * from JdbcStudents")
    List<Student> selectAllStudent();

    @Insert("insert into JdbcStudents values (#{id}, '${name}', #{createdAt})")
    void insertStudent(int id, String name, Timestamp createdAt);

    @Update("update JdbcStudents set name ='${name}' where id = #{id}")
    void updateStudent(String name, int id);

    @Delete("delete from JdbcStudents where id = #{id}")
    void deleteStudent(int id);
}
