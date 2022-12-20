package com.nhnacademy.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "logoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(Objects.nonNull(session)) {
            session.invalidate();
            for(Cookie cookie : req.getCookies()) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
        dispatcher.forward(req, resp);
//        resp.sendRedirect("/login");
    }
}
