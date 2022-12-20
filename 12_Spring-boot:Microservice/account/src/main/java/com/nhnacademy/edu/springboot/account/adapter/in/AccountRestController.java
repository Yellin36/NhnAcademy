package com.nhnacademy.edu.springboot.account.adapter.in;

import com.nhnacademy.edu.springboot.account.domain.Account;
import com.nhnacademy.edu.springboot.account.domain.AccountService;
import com.nhnacademy.edu.springboot.account.domain.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountRestController {
    private final AccountService accountService;

    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable("id") Long id) {
        return accountService.getAccount(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @DeleteMapping("/{id}")
    public Result deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteAccount(id);

        return new Result("OK");
    }
}
