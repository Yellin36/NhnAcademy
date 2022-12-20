package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.exception.LogoutFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logoutProcess(HttpSession session) {
        if (session.getAttribute("sessionId") == null) {
            throw new LogoutFailedException();
        }
        session.removeAttribute("sessionId");
        session.removeAttribute("option");

        return "index";
    }
}
