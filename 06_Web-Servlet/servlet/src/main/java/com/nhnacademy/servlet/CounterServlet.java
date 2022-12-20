package com.nhnacademy.servlet;

import com.nhnacademy.servlet.util.Util;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class CounterServlet extends HttpServlet {
    int count=0;

    @Override
    public void init(ServletConfig config) throws ServletException {
        String countString = config.getInitParameter("count");
        count = Integer.valueOf(countString);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(++count);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("방문 수: " + Util.increaseCount(getServletContext()));


    }
}
