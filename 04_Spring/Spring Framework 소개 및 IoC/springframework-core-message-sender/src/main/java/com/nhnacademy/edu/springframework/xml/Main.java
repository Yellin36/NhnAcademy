package com.nhnacademy.edu.springframework.xml;

import com.nhnacademy.edu.springframework.config.ServiceConfig;
import com.nhnacademy.edu.springframework.messagesender.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        User user = new User("yerin@gmail.com", "010-1234-1234");
        String message = "hello";

        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(ServiceConfig.class);

        c.getBean("doorayMessageSender", DoorayMessageSender.class).sendMessage(user, message);
    }
}
