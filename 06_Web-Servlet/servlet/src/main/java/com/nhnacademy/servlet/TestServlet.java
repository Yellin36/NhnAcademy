package com.nhnacademy.servlet;

import com.nhnacademy.servlet.util.Util;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;
import java.io.IOException;
import java.util.Optional;

@Slf4j
public class TestServlet extends HttpServlet {
    //private static final Logger LOGGER = LoggerFactory.getLogger(TestServlet.class);
    //을 반복적이고 쓰기 귀찮으니까
    String title;
    String name;
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("service() call");
        super.service(req, resp);
    }

    @Override
    public void destroy() {
        log.info("destroy() call");
        super.destroy();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("init() call");
//        title = config.getInitParameter("title");
//        name = config.getInitParameter("name");
        super.init(config);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = getServletConfig().getInitParameter("title");
        String name = getServletConfig().getInitParameter("name");

        resp.getWriter().println("hello, " + title + " " + name);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("방문 수: " + Util.increaseCount(getServletContext()));

    }
}

