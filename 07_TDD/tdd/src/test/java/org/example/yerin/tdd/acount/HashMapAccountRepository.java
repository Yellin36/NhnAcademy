package org.example.yerin.tdd.acount;

import java.util.HashMap;

public class HashMapAccountRepository implements AccountRepository {
    private final HashMap<Long, Account> source = new HashMap<>();

    @Override
    public void insert(Account account) {
        source.put(account.getId(), account);
    }

    @Override
    public Account findById(Long id) {
        return source.get(id);
    }

    @Override
    public Account findByUsername(String username) {
        return source.values().stream()
                .filter(x -> x.getUsername().equals(username))
                .findFirst()
                .get();
    }
}