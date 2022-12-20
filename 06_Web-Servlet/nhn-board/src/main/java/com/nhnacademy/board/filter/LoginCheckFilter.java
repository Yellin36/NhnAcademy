package com.nhnacademy.board.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "*.do", initParams = {
        @WebInitParam(name="exclude-url", value = "/login.do\n/logout.do\n/loginForm.do")
})
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }
}
