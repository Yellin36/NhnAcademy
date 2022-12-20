package com.nhnacademy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentRegisterFormController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/studentRegister.jsp";
    }
}
