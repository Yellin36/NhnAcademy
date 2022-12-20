package org.example.yerin.tdd.acount;

public interface AccountRepository {
    void insert(Account account);

    Account findById(Long id);

    Account findByUsername(String username);
}
