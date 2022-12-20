package com.nhnacademy.nhn_mart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String initId = req.getServletContext().getInitParameter("id");
        String initPwd = req.getServletContext().getInitParameter("pwd");

        String inputId = req.getParameter("id");
        String inputPwd = req.getParameter("pwd");

        if(inputId.equals(initId) && inputPwd.equals(initPwd)) {
            HttpSession session = req.getSession();
            session.setAttribute("id", inputId);

            return "redirect:/init.do";
        }
        return "redirect:/loginForm.do";
    }
}
