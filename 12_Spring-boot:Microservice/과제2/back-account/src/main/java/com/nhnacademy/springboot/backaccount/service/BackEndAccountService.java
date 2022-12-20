package com.nhnacademy.springboot.backaccount.service;

import com.nhnacademy.springboot.backaccount.domain.Account;
import com.nhnacademy.springboot.backaccount.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BackEndAccountService implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

}
