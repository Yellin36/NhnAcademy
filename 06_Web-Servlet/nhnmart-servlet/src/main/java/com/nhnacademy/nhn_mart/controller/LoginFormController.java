package com.nhnacademy.nhn_mart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFormController implements Command{

    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        return "redirect:/loginForm.jsp";
    }
}
