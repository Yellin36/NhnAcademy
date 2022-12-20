package com.nhnacademy.springboot.board.service;

import com.nhnacademy.springboot.board.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardUserServiceTest {
    @Autowired
    BoardUserService boardUserService;
    @Autowired
    UserRepository userRepository;
    @Test
    void getUser() {
        userRepository.findAll().stream().forEach(System.out::println);
    }
}