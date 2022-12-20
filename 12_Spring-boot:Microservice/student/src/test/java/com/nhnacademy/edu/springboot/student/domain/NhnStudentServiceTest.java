package com.nhnacademy.edu.springboot.student.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class NhnStudentServiceTest {

    @Autowired
    NhnStudentService nhnStudentService;

    @Test
    void test_getStudents() {
        //when
        List<Student> studentList = nhnStudentService.getStudents();

        //then
        assertThat(studentList).hasSize(1);
    }
}