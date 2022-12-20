package com.nhnacademy.nhn_mart.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "*.do", initParams = {
        @WebInitParam(name = "exclude-url", value = "/login.do\n/logout.do\n/loginForm.do\n/index.jsp\n/locale.do")
})
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
            } else {
                ((HttpServletResponse) servletResponse).sendRedirect("/loginForm.do");
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
