package com.nhnacademy.board.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class BoardUserRepository implements UserRepository, Serializable {
    private Map<String, User> users = new ConcurrentHashMap<>();

    @Override
    public void add(User user) {
        if(users.containsKey(user.getId())) {
            throw new IllegalArgumentException("Duplicate User");
        }
        users.put(user.getId(), user);
    }

    @Override
    public void modify(User user) {
        if(!users.containsKey(user.getId())) {
            throw new NoSuchElementException("No Such User");
        }
        users.replace(user.getId(), user);
    }

    @Override
    public User remove(String id) {
        if(!users.containsKey(id)) {
            throw new NoSuchElementException("No Such User");
        }
        return users.remove(id);
    }

    @Override
    public User getUser(String id) {
        if(!users.containsKey(id)) {
            throw new NoSuchElementException("No Such User");
        }
        return users.get(id);
    }

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }
}
