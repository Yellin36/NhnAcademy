package com.nhnacademy.springmvc.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class ImageControllerTest {
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ImageController()).build();
    }


    @Test
    void displayImage() throws Exception {
        mockMvc.perform(get("/image")
                        .param("filename", "/Users/yerin/Downloads/ponyo006.jpeg"))
                .andExpect(status().isOk());
    }
}