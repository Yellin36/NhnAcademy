package com.nhnacademy.edu.springframework.xml;

import com.nhnacademy.edu.springframework.messagesender.Service;
import com.nhnacademy.edu.springframework.messagesender.Services;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionMain {
    public static void main(String[] args) {
        try {
            ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/beans.xml");

            Service service1 = context.getBean("senderService", Service.class);
            service1.send(new User("12@d.com", "234-234"), "hello constructor");

            System.out.println("--------------------------------------------------------------");

//            Services service2 = context.getBean("sendersService", Services.class);
//            service2.send(new User("12@d.com", "234-234"), "hello constructor");
        }finally {

        }
    }
}
