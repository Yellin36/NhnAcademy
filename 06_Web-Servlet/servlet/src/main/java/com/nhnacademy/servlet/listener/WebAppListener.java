package com.nhnacademy.servlet.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@WebListener
public class WebAppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;

        int counter=0;
        try (DataInputStream dis = new DataInputStream(servletContext.getResourceAsStream(counterFilePath))) {
            counter = dis.read();
        } catch (IOException e) {

        }
        servletContext.setAttribute("counter", counter);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;

        int counter = (int) servletContext.getAttribute("counter");

        try(OutputStream os = Files.newOutputStream(Paths.get(servletContext.getResource(counterFilePath).toURI()));
            DataOutputStream dos = new DataOutputStream(os)){
            dos.writeInt(counter);
        }catch (IOException | URISyntaxException e) {

        }
    }

}
