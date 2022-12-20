package com.nhnacademy.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String sessionId = (String) request.getSession().getAttribute("sessionId");

        if(sessionId == null) {
            response.sendRedirect("/");
            return false;
        }

        return true;
    }
}
