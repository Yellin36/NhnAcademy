package com.nhnacademy.nhn_mart.initializer;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes({
        javax.servlet.http.HttpServlet.class,
        javax.servlet.Filter.class,
        javax.servlet.ServletContextListener.class,
        javax.servlet.http.HttpSessionListener.class
})
public class WebAppInitializer implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        servletContext.setInitParameter("productKoNames", "양파,계란,파,사과");
        servletContext.setInitParameter("productNames", "onion,egg,green-onion,apple");
        servletContext.setInitParameter("productPrices", "1000,2000,500,2000");
        servletContext.setInitParameter("productAmounts", "2,5,10,20");

        servletContext.setInitParameter("id", "yerin");
        servletContext.setInitParameter("pwd", "1234");
    }
}
