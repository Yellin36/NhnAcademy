package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.exception.LoginFailedException;
import com.nhnacademy.springmvc.repository.CustomerRepository;
import com.nhnacademy.springmvc.repository.ManagerRepository;
import com.nhnacademy.springmvc.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.ThrowableAssert.catchThrowable;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class LoginControllerTest {
    MockMvc mockMvc;

    UserRepository customerRepository;
    UserRepository managerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = mock(CustomerRepository.class);
        managerRepository = mock(ManagerRepository.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new LoginController(customerRepository, managerRepository)).build();
    }

    @Test
    @DisplayName("로그인 페이지 이동 성공")
    void loginForm_success() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginForm"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"customer", "admin"})
    @DisplayName("로그인 실패 - 없는 사용자 정보")
    void loginProcess_failByWrongInput_thenThrowLoginFailedException(String option) {
        UserRepository userRepository = (option.equals("customer")) ? customerRepository : managerRepository;

        when(userRepository.matches(anyString(), anyString())).thenReturn(false);

        Throwable th = catchThrowable(() -> mockMvc.perform(post("/login")
                .param("id", "id")
                .param("password", "pwd")
                .param("option", option)));

        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(LoginFailedException.class);

        verify(userRepository, times(1)).matches(anyString(), anyString());

    }

    @ParameterizedTest
    @ValueSource(strings = {"customer", "admin"})
    @DisplayName("로그인 성공")
    void loginForm_success(String option) throws Exception {
        String id = "user@1";
        String password = "1234";

        UserRepository userRepository = (option.equals("customer")) ? customerRepository : managerRepository;

        when(userRepository.matches(anyString(), anyString())).thenReturn(true);

        mockMvc.perform(post("/login")
                        .param("id", id)
                        .param("password", password)
                        .param("option", option))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/" + option + "/list"));

        verify(userRepository, times(1)).matches(anyString(), anyString());
    }
}