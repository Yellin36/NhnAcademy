package com.nhnacademy.edu.jdbc1.mybatis;

import com.nhnacademy.edu.jdbc1.mybatis.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    //Resources.getResourceAsStream() 메소드를 이용하여 "com/nhnacademy/edu/jdbc1/mybatis/mybatis-config.xml" 파일의 InputStream 을 생성합니다.
    //SqlSessionFactoryBuilder.build() 메소드를 이용하여 SqlSessionFactory 객체를 생성합니다.
    //SqlSessionFactory.openSession() 메소드를 이용하여 SqlSession 객체를 생성합니다.
    //SqlSession.selectOne() 메소드를 이용하여 Students 테이블의 id 1번 데이터를 조회합니다.
    //============================================
    //Student student = sqlSession.selectOne("com.nhnacademy.edu.jdbc1.mybatis.StudentMapper.selectStudent", 1);
    //============================================
    //조회한 결과를 System.out.println 으로 콘솔에 표시합니다.
    public static void main(String[] args) throws IOException {
        String resource = "com/nhnacademy/edu/jdbc1/mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Student student = sqlSession.selectOne("com.nhnacademy.edu.jdbc1.mybatis.StudentMapper.selectStudent", 1);
            System.out.println(student);
        }

    }
}