package com.nhnacademy.edu.springframework.xml;

import com.nhnacademy.edu.springframework.messagesender.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.Service;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ScopeMain {
    public static void main(String[] args) {
        String location = "classpath:/beans.xml";
        User user = new User("4df@sd.com", "123-342");
        String message = "hello";

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(location);
        System.out.println("S-T-A-R-T");
        new Service(context.getBean("emailMessageSender", EmailMessageSender.class)).send(user, message);
        new Service(context.getBean("emailMessageSender", EmailMessageSender.class)).send(user, message);
        new Service(context.getBean("smsMessageSender", SmsMessageSender.class)).send(user, message);
        new Service(context.getBean("smsMessageSender", SmsMessageSender.class)).send(user, message);

        context.close();
    }
}
