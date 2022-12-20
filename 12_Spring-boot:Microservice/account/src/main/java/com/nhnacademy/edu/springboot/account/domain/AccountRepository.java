package com.nhnacademy.edu.springboot.account.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findAll();
    List<Account> findByNumber(String number);
}
