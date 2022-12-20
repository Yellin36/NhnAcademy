package com.nhnacademy.servlet.cookie;

import com.nhnacademy.servlet.util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class ReadCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie localeCookie = Util.getCookie(req, "locale");
        String locale = localeCookie.getValue();

        String message = ResourceBundle.getBundle("message", new Locale(locale))
                .getString("hello");
        resp.setContentType("text/plain; charset=UTF-8");
        resp.getWriter().println(message);
    }
}
