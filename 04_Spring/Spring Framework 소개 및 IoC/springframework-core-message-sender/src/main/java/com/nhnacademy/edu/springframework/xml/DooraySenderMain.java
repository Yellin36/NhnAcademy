package com.nhnacademy.edu.springframework.xml;

import com.nhnacademy.edu.springframework.config.DoorayConfig;
import com.nhnacademy.edu.springframework.config.ServiceConfig;
import com.nhnacademy.edu.springframework.messagesender.DoorayMessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

public class DooraySenderMain {

    public static void main(String[] args) {
        User user = new User("yerin@gmail.com", "010-1234-1234");
        String message = "hello";

        AnnotationConfigApplicationContext c = new AnnotationConfigApplicationContext(DoorayConfig.class);

        c.getBean("doorayMessageSender", DoorayMessageSender.class).sendMessage(user, message);
    }
}
