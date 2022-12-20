package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;

public interface UserRepository {
    boolean exists(String id);
    User getUser(String id);

    User registerUser(String id, String password, String name);
    boolean matches(String id, String password);
}
