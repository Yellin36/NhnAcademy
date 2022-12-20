package com.nhnacademy.edu.springframework.xml;

import com.nhnacademy.edu.springframework.messagesender.Service;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomQualifierMain {
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/beans.xml");

            Service service = context.getBean("senderService", Service.class);
            service.send(new User("12@d.com", "234-234"), "hello constructor");
        }finally {

        }
    }
}
