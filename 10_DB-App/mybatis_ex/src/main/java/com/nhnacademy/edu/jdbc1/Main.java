package com.nhnacademy.edu.jdbc1;

import com.nhnacademy.edu.jdbc1.mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "com/nhnacademy/edu/jdbc/mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Student student = sqlSession.selectOne("com.nhnacademy.edu.jdbc1.mybatis.StudentMapper.selectStudent", 1);
            System.out.println(student);
        }

    }
}