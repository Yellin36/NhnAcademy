package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.User;
import com.nhnacademy.springmvc.exception.AlreadyRegisteredUserException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ManagerRepository implements UserRepository {
    private final Map<String, User> managerMap = new HashMap<>();

    @Override
    public boolean exists(String id) {
        return managerMap.containsKey(id);
    }

    @Override
    public User getUser(String id) {
        return (exists(id)) ? managerMap.get(id) : null;
    }

    @Override
    public User registerUser(String id, String password, String name) {
        if(exists(id)) {
            throw new AlreadyRegisteredUserException(id);
        }
        User user = new User(id, password, name);

        managerMap.put(id, user);

        return user;
    }
    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getUser(id))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}
