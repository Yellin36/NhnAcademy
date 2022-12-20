package com.nhnacademy.jdbc.board.domains.user.service.impl;

import com.nhnacademy.jdbc.board.domains.user.domain.User;
import com.nhnacademy.jdbc.board.domains.user.mapper.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BoardUserServiceTest {
    BoardUserService userService;
    UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = mock(UserMapper.class);
        userService = new BoardUserService(userMapper);
    }

    @Test
    void getUser() {
        String userId = "user";
        Optional<User> user = Optional.of(new User("id", "", "", 1, new Date()));

        when(userMapper.selectUser(userId)).thenReturn(user);

        assertThat(userService.getUser(userId)).isPresent();
    }
}