package com.nhnacademy.jdbc.board.domains.user.service.impl;

import com.nhnacademy.jdbc.board.domains.user.domain.User;
import com.nhnacademy.jdbc.board.domains.user.mapper.UserMapper;
import com.nhnacademy.jdbc.board.domains.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BoardUserService implements UserService {
    private final UserMapper userMapper;

    public BoardUserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Optional<User> getUser(String userId) {
        return userMapper.selectUser(userId);
    }
}
