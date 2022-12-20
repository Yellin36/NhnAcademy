package com.nhnacademy.edu.springboot.account.adapter.in;

import com.nhnacademy.edu.springboot.account.domain.Account;
import com.nhnacademy.edu.springboot.account.domain.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web")
public class AccountWebController {
    private final AccountService accountService;

    @GetMapping("/account/{id}")
    public String getAccount(@PathVariable("id") Long id,
                             Model model) {
        Account account = accountService.getAccount(id);

        model.addAttribute("account", account);

        return "account";
    }
}
