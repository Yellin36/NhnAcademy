package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.UserLoginRequest;
import com.nhnacademy.springmvc.exception.LoginFailedException;
import com.nhnacademy.springmvc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class LoginController {
    private UserRepository customerRepository;
    private UserRepository managerRepository;

    private final String CUSTOMER = "customer";

    public LoginController(UserRepository customerRepository, UserRepository managerRepository) {
        this.customerRepository = customerRepository;
        this.managerRepository = managerRepository;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String loginProcess(@ModelAttribute UserLoginRequest request,
                               HttpSession session) {
        login(request);

        session.setAttribute("sessionId", request.getId());
        session.setAttribute("option", request.getOption());

        return "redirect:/" + request.getOption() + "/list";
    }

    private void login(UserLoginRequest request) {
        String option = request.getOption();
        String id = request.getId();
        String password = request.getPassword();

        log.info("logincontroller = {} {} {}", option, id, password);
        UserRepository repository = (option.equals(CUSTOMER)) ? customerRepository : managerRepository;

        if (!repository.matches(id, password)) {
            throw new LoginFailedException();
        }
    }

}
