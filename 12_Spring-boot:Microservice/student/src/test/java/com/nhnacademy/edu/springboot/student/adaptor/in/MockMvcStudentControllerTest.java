package com.nhnacademy.edu.springboot.student.adaptor.in;

import com.nhnacademy.edu.springboot.student.domain.Student;
import com.nhnacademy.edu.springboot.student.domain.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class MockMvcStudentControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    StudentService studentService;

    @Test
    void testGetStudents() throws Exception {
        given(studentService.getStudents()).willReturn(
                List.of(new Student(1L, "zbum", 100),
                        new Student(2L, "manty", 90)));

        mvc.perform(get("/students"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[1].name", equalTo("manty")));
    }

}