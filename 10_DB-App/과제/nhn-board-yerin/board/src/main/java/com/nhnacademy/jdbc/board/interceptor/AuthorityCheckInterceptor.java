package com.nhnacademy.jdbc.board.interceptor;

import com.nhnacademy.jdbc.board.exception.InvalidAuthorAccessException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthorityCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        int authority = (int) request.getSession().getAttribute("authority");

        if (authority != 1) {
            throw new InvalidAuthorAccessException(authority);
        }
        return true;
    }
}
