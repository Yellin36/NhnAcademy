package com.nhnacademy.servlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

@WebFilter(filterName = "characterEncodingFilter", urlPatterns = "/*", initParams = {
        @WebInitParam(name="encoding", value="UTF-8")
})
public class CharacterEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(this.encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
    }
}
