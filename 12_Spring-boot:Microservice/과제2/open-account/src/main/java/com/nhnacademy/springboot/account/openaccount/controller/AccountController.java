package com.nhnacademy.springboot.account.openaccount.controller;

import com.nhnacademy.springboot.account.openaccount.domain.Account;
import com.nhnacademy.springboot.account.openaccount.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }
    // curl -XGET http://localhost:8080/accounts

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") Long id) {
        return accountService.getAccount(id);
    }
    // curl -XGET http://localhost:8080/accounts/1

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }
    // curl -X POST http://localhost:8080/accounts -H 'Content-Type: application/json' -d '{"id" : 5, "number" : "123-342", "balance" : 1000}'

    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable("id") Long id) {
        return accountService.deleteAccount(id);
    }
    // curl -XDELETE http://localhost:8080/accounts/2
}
