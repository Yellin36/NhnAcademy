package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.exception.LogoutFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class LogoutControllerTest {
    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new LogoutController()).build();
    }

    @Test
    @DisplayName("로그아웃 실패 - 로그인안되어있음")
    void logoutProcess_fileByNoSession_thenThrowLogoutFailedException() {
        Throwable th = catchThrowable(() -> mockMvc.perform(get("/logout")));

        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(LogoutFailedException.class);
    }

    @Test
    @DisplayName("로그아웃 성공")
    void logoutProcess_success() throws Exception {
        String sessionId = "user@1";

        mockMvc.perform(get("/logout")
                        .sessionAttr("sessionId", sessionId))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}