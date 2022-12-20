package com.nhnacademy.servlet.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LoginCheckFilter implements Filter {
    private Set<String> excludeUrls = new HashSet<>();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String[] excludeURL = filterConfig.getInitParameter("exclude-url").split("\n");

        excludeUrls = Arrays.stream(excludeURL)
                .map(String::trim)
                .collect(Collectors.toSet());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest)servletRequest).getSession(false);


        if(Objects.isNull(session)) {
            if(excludeUrls.contains(((HttpServletRequest)servletRequest).getRequestURI())) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
            else {
                ((HttpServletResponse) servletResponse).sendRedirect("/login.html");
//            RequestDispatcher rd = servletRequest.getRequestDispatcher("/loginForm");
//            rd.forward(servletRequest, servletResponse);
            }
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
