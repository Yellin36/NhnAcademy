package com.nhnacademy.edu.springboot.student.adaptor.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.edu.springboot.student.domain.Student;
import com.nhnacademy.edu.springboot.student.domain.StudentRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private StudentRepository studentRepository;

    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @DisplayName("학생목록 조회")
    @Order(1)
    void test_getStudents() throws Exception {
        given(studentRepository.findAll()).willReturn(
                List.of(new Student(1L, "zbum", 100),
                        new Student(2L, "manty", 90)));

        mvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].name", equalTo("zbum")));


    }

    @Test
    @Order(2)
    @DisplayName("1번 학생 조회")
    void getStudent() throws Exception {
        //given
        Long id = 1L;

        given(studentRepository.findById(id)).willReturn(
                Optional.of(new Student(1L, "zbum", 100)));

        mvc.perform(get("/students/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", equalTo("zbum")));
    }

    @Test
    @Order(3)
    @DisplayName("학생 등록")
    void createStudent() throws Exception {
        //given
        Student seominji = new Student(20L, "서민지", 100);

        given(studentRepository.save(seominji)).willReturn(seominji);
        //when
        mvc.perform(post("/accounts")
                        .content(objectMapper.writeValueAsString(seominji)) //json string type
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(20)));
    }

    @Test
    @Order(4)
    @DisplayName("학생 삭제")
    void deleteStudent() throws Exception {
        Long id = 4L;

        willDoNothing().given(studentRepository).deleteById(id);

        mvc.perform(delete("/accounts/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.result", equalTo("OK")));
    }
}