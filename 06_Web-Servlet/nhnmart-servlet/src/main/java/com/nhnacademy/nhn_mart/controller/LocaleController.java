package com.nhnacademy.nhn_mart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class LocaleController implements Command{
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String lang = req.getParameter("lang");
        System.out.println(lang);

        return "/index.jsp?lang="+lang;
    }
}
