package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.domains.user.domain.User;
import com.nhnacademy.jdbc.board.domains.user.service.UserService;
import com.nhnacademy.jdbc.board.exception.InvalidUserException;
import com.nhnacademy.jdbc.board.exception.LoginFailedException;
import com.nhnacademy.jdbc.board.exception.ValidationFailedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import javax.servlet.http.HttpSession;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class LoginControllerTest {
    MockMvc mockMvc;

    UserService userService;

    @BeforeEach
    void setUp() {
        userService = mock(UserService.class);

        mockMvc = MockMvcBuilders.standaloneSetup(new LoginController(userService)).build();
    }

    @Test
    void loginForm() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginForm"));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void login_failedByValidationFailed_thenThrowValidationFailedException(String value) {
        String id = value;
        String password = value;

        Throwable th = catchThrowable(() -> mockMvc.perform(post("/login")
                .param("id", id)
                .param("password", password))
        );
        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(ValidationFailedException.class);
    }

    @Test
    void login_failedByInvalidUserId_thenThrowInvalidUserException() {
        String id = "someone";
        String password = "1234";

        when(userService.getUser(id)).thenThrow(new InvalidUserException(id));

        Throwable th = catchThrowable(() -> mockMvc.perform(post("/login")
                .param("id", id)
                .param("password", password)
                .param("authority", "2"))
        );
        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(InvalidUserException.class);
    }

    @Test
    void login_failedByIncorrectPassword_thenThrowLoginFailedException() {
        String id = "user";
        String password = "1234";

        User user = new User(id, "1324", "user", 2, null);

        when(userService.getUser(id)).thenReturn(Optional.of(user));

        Throwable th = catchThrowable(() -> mockMvc.perform(post("/login")
                .param("id", id)
                .param("password", password)
                .param("authority", "2"))
        );
        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(LoginFailedException.class);
    }

    @Test
    void login_success() throws Exception {
        String id = "user";
        String password = "1234";
        String name = "suer";
        int authority = 2;

        User user = new User(id, password, name, authority, null);

        when(userService.getUser(id)).thenReturn(Optional.of(user));

        MvcResult result = mockMvc.perform(post("/login")
                        .param("id", id)
                        .param("password", password)
                        .param("authority", "2"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andReturn();

        HttpSession session = result.getRequest().getSession();
        assertThat(session.getAttribute("sessionId")).isEqualTo(id);
        assertThat(session.getAttribute("name")).isEqualTo(name);
        assertThat(session.getAttribute("authority")).isEqualTo(authority);

        verify(userService, times(1)).getUser(anyString());
    }
}