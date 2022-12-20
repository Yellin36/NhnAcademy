package com.nhnacademy.servlet;

import com.nhnacademy.servlet.util.Util;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@Slf4j
public class NowServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println(new Date());
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().println("방문 수: " + Util.increaseCount(getServletContext()));
    }


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("service() call");
        super.service(req, resp);
    }

    //리소스 반납, cleaning 함수들 실행하는 곳
    @Override
    public void destroy() {
        log.info("destroy() call");
        super.destroy();
    }

    //storage, db, properties 에서 데이터를 가져오는 시간이 오래걸리는 작업을 실행하는 곳
    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("init() call");
        super.init(config);
    }
}
