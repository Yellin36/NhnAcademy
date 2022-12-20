package com.nhnacademy.edu.springboot.student.adaptor.in;

import com.nhnacademy.edu.springboot.student.domain.Student;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RandomPortStudentControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @Order(1)
    void testGetStudents() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Student>> exchange = restTemplate.exchange(
                "/students",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Student>>() {}
        );
        assertThat(exchange.getBody())
                .contains(new Student(1L, "zbum", 100));
    }

    @Test
    @Order(2)
    void testGetStudent() throws Exception {
        ResponseEntity<Student> response = restTemplate.getForEntity(
                "/students/{id}",
                Student.class,
                1L
        );
        assertThat(response.getBody()).isEqualTo(new Student(1L, "zbum", 100));
    }
    @Test
    @Order(3)
    void testCreateStudent() throws Exception {
        Student student = new Student(10L, "hahaha", 39);


        ResponseEntity<Student> exchange = restTemplate.postForEntity(
                "/students",
                student,
                Student.class
        );

        assertThat(exchange.getBody()).isEqualTo(student);

    }
    @Test
    @Order(4)
    void testDeleteStudent() throws Exception {
        restTemplate.delete(
                "/students/{id}",
                10L
        );
    }

}