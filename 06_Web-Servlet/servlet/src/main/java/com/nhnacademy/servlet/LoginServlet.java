package com.nhnacademy.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@WebServlet(name="loginServlet", urlPatterns = "/login", initParams = {
        @WebInitParam(name="id", value="yerin"),
        @WebInitParam(name="pwd", value = "1234")
})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(Objects.isNull(session)) {
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
//            dispatcher.forward(req, resp);
            resp.sendRedirect("/login.html");
        }
        else {
            String id = (String) session.getAttribute("id");
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().println("로그인 성공: " + id);
            resp.getWriter().println("<br/><a href='/logout' >[로그아웃]</a>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String initId = getServletConfig().getInitParameter("id");
        String initPwd = getServletConfig().getInitParameter("pwd");

        String id = req.getParameter("id");
        String pwd = req.getParameter("pwd");

        log.info(id + " " + pwd);
        if(id.equals(initId) && pwd.equals(initPwd)) {
            log.info("로그인 성공");
            HttpSession session = req.getSession();
            session.setAttribute("id", id);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/login");
            dispatcher.forward(req, resp);
//            resp.sendRedirect("/login");
        }
        else {
            log.info(id);
//            RequestDispatcher dispatcher = req.getRequestDispatcher("/login.html");
//            dispatcher.forward(req, resp);

            resp.sendRedirect("/login.html");
        }
    }
}
