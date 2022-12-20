package com.nhnacademy.edu.springframework.xml;

import com.nhnacademy.edu.springframework.config.MainConfig;
import com.nhnacademy.edu.springframework.config.ServiceConfig;
import com.nhnacademy.edu.springframework.messagesender.Service;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationMain {
    public static void main(String[] args) {
        String buildPackages = "com.nhnacademy.edu.springframework";
        AnnotationConfigApplicationContext ct = new AnnotationConfigApplicationContext(buildPackages);
        User user = new User("2dfs@sdf.com", "123-234");
        String message = "왜 안되는걸까요?";

        Service service = ct.getBean("service", Service.class);

        service.send(user, message);

//        ct.getBeanFactory().getBeanNamesIterator().forEachRemaining(s -> {
//            System.out.println(s);
//        });
    }
}
