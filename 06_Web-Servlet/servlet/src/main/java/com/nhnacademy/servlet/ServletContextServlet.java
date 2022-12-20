package com.nhnacademy.servlet;

import com.nhnacademy.servlet.util.Util;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        try {
            PrintWriter out = resp.getWriter();

            out.println(context.getContextPath());
            out.println(context.getMajorVersion());
            out.println(context.getMinorVersion());
            out.println(context.getEffectiveMajorVersion());
            out.println(context.getEffectiveMinorVersion());
            out.println(context.getRealPath("/servletcontext"));
            out.println(context.getInitParameter("url"));


        } catch (IOException e) {

        }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("방문 수: " + Util.increaseCount(getServletContext()));
    }
}
