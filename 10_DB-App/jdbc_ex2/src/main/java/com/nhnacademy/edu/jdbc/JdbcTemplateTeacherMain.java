package com.nhnacademy.edu.jdbc;

import com.nhnacademy.edu.jdbc.config.MainConfig;
import com.nhnacademy.edu.jdbc.domain.Teacher;
import com.nhnacademy.edu.jdbc.service.TeacherService;
import com.sun.tools.javac.Main;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

public class JdbcTemplateTeacherMain {
    private static final Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class)

        ) {
            TeacherService bean = ctx.getBean(TeacherService.class);

            System.out.println(bean.getTeacher(1L));
            bean.getAllTeachers().forEach(System.out::println);

            try {
                bean.insertAndDelete(new Teacher(50L, "선생50", new Date()));
            }catch (Exception e) {}
            log.info("after insert and delete For Rollback");
            bean.getAllTeachers().forEach(System.out::println);

            try {
                bean.insertAndDeleteWithoutTransaction(new Teacher(50L, "선생50", new Date()));
            }catch (Exception e) {}
            log.info("after insert and delete For Rollback");
            bean.getAllTeachers().forEach(System.out::println);
        }
    }
}
