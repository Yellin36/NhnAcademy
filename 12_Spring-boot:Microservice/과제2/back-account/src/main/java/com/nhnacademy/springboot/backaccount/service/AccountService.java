package com.nhnacademy.springboot.backaccount.service;

import com.nhnacademy.springboot.backaccount.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccount(Long id);

    Account createAccount(Account account);

    void deleteAccount(Long id);
}
