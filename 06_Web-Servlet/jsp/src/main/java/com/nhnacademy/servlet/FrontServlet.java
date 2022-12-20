package com.nhnacademy.servlet;

import com.nhnacademy.controller.Command;
import com.nhnacademy.controller.StudentRegisterController;
import com.nhnacademy.controller.StudentRegisterFormController;
import com.nhnacademy.controller.StudentViewController;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet(name="frontServlet", urlPatterns = "*.do")
public class FrontServlet extends HttpServlet {
    private static final String REDIRECT_PREFIX = "redirect:";

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        try {
            Command command = resolveServlet(req.getServletPath());

//            RequestDispatcher rd = req.getRequestDispatcher(processingServletPath);
//            rd.include(req, resp);

            String view = command.execute(req, resp);

//            String view = (String) req.getAttribute("view");
            if(view.startsWith(REDIRECT_PREFIX)) {
                resp.sendRedirect(view.substring(REDIRECT_PREFIX.length()));
            } else {
                RequestDispatcher rd = req.getRequestDispatcher(view);
                rd.include(req, resp);
            }
        } catch (Exception e) {
            log.error("", e);
            req.setAttribute("exception", e);
            RequestDispatcher rd = req.getRequestDispatcher("/error.jsp");
            rd.forward(req, resp);
        }
    }

    private Command resolveServlet(String servletPath) {
        Command command = null;

        if ("/student/register.do".equals(servletPath)) {
            command = new StudentRegisterController();
        } else if ("/student/registerForm.do".equals(servletPath)) {
            command = new StudentRegisterFormController();
        } else if ("/student/view.do".equals(servletPath)) {
            command = new StudentViewController();
        }
        return command;
    }
}
