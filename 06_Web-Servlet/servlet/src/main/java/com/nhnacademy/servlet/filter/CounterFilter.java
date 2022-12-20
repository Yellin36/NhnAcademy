package com.nhnacademy.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "counterFilter", urlPatterns = "/*")
public class CounterFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        int counter = (int) servletRequest.getServletContext().getAttribute("counter");

        servletRequest.getServletContext().setAttribute("counter", ++counter);

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
