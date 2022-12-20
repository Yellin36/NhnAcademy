package com.nhnacademy.jdbc.board.domains.user.service;

import com.nhnacademy.jdbc.board.domains.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author : marco@nhnacademy.com
 * @Date : 17/05/2022
 */
@Service
public interface UserService {
    Optional<User> getUser(String userId);
}
