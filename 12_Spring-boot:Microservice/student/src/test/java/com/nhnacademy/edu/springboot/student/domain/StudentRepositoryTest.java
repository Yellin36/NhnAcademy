package com.nhnacademy.edu.springboot.student.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {
    @Autowired
    TestEntityManager testEntityManager;
    @Autowired
    StudentRepository studentRepository;

    @Test
    void testStudentRepository() throws Exception {
        //given
        Student zbum = new Student(1L, "zbum", 100);
        studentRepository.save(zbum);

        //when
        Optional<Student> actual = studentRepository.findById(1L);

        //then
        assertThat(actual).isPresent();
        assertThat(actual.get()).isEqualTo(zbum);
    }
    @Test
    void testFindByName() throws Exception {
        //given
        String leeJoonSoo = "LeeJoonSoo";
        Student ljs = new Student(11L, "LeeJoonSoo", 100);
        testEntityManager.persist(ljs);

        //when
        List<Student> actual = studentRepository.findByName(leeJoonSoo);

        //then
        assertThat(actual).hasSize(1);
        assertThat(actual.get(0)).isEqualTo(ljs);
    }

}

