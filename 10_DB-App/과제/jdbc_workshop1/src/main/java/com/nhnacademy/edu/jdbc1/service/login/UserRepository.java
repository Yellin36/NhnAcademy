package com.nhnacademy.edu.jdbc1.service.login;

import com.nhnacademy.edu.jdbc1.domain.User;

public interface UserRepository {
    int insert(User user);

    User findById(int id);

    User findByUserName(String username);
}
