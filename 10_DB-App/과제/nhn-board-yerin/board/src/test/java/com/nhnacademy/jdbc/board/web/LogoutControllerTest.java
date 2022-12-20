package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.exception.LogoutFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;
import org.thymeleaf.spring5.expression.Mvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class LogoutControllerTest {
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new LogoutController()).build();
    }

    @Test
    void logout_failedByNonLoginSession_thenThrowLogoutFailedException() {
        Throwable th = catchThrowable(() ->
                mockMvc.perform(get("/logout")));

        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(LogoutFailedException.class);
    }

    @Test
    void logout_success() throws Exception {
        String sessionId = "user";

        MvcResult result = mockMvc.perform(get("/logout")
                .sessionAttr("sessionId", sessionId))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andReturn();

        assertThat(result.getRequest().getSession().getAttribute("sessionId")).isNull();
    }
}