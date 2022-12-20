package com.nhnacademy.nhn_mart.servlet;

import com.nhnacademy.nhn_mart.controller.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try{
            Command command = resolveServlet(req.getServletPath());
            String view = command.execute(req, resp);

            if(view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("exception", e);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }

    }
    private Command resolveServlet(String servletPath) {
        Command command = null;

        if(servletPath.equals("/cart.do")) {
            command = new CartController();
        } else if (servletPath.contains("/foods.do")) {
            command = new FoodsController();
        } else if (servletPath.equals("/init.do")) {
            command = new InitController();
        } else if (servletPath.equals("/login.do")) {
            command = new LoginController();
        } else if (servletPath.equals("/loginForm.do")) {
            command = new LoginFormController();
        } else if (servletPath.equals("/logout.do")) {
            command = new LogoutController();
        } else if (servletPath.contains("/pay.do")) {
            command = new PayController();
        } else if (servletPath.contains("/locale.do")) {
            command = new LocaleController();
        }
        return command;
    }
}
