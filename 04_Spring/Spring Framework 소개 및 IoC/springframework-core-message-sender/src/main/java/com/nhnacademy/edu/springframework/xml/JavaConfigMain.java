package com.nhnacademy.edu.springframework.xml;

import com.nhnacademy.edu.springframework.config.MainConfig;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigMain
{
    public static void main(String[] args) {
        User user = new User("2dfs@sdf.com", "123-234");
        String message = "12da gsdgaga";

        String basePackage = "com.nhnacademy.edu.springframework.messagesender";
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainConfig.class);

        MessageSender sms = context.getBean("smsMessageSender", MessageSender.class);
        MessageSender email = context.getBean("emailMessageSender", MessageSender.class);

        sms.sendMessage(user, message);
        email.sendMessage(user, message);

        context.close();
    }
}
