package com.nhnacademy.springmvc.interceptor;

import com.nhnacademy.springmvc.exception.InvalidAuthorAccessException;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OptionCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String option = (String) request.getSession().getAttribute("option");

        if(!request.getServletPath().startsWith("/" + option)) {
            throw new InvalidAuthorAccessException(option);
        }
        return true;
    }
}
