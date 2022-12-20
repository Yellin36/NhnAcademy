package com.nhnacademy.edu.jdbc1.web;


import com.nhnacademy.edu.jdbc1.service.login.DefaultUserLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Slf4j
@Controller
public class LoginController {
    private DefaultUserLoginService userLoginService;

    public LoginController(DefaultUserLoginService userLoginService) {
        this.userLoginService = userLoginService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginForm";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session) throws SQLException {
        if(!userLoginService.login(username, password)) {
            return "loginForm";
        }
        session.setAttribute("sessionId", username);

        return "redirect:/course";
    }


}
