package com.nhnacademy.springboot.account.openaccount.service;

import com.nhnacademy.springboot.account.openaccount.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccount(Long id);

    Account createAccount(Account account);

    String deleteAccount(Long id);
}
