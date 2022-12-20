package com.nhnacademy.edu.springframework.xml;

import com.nhnacademy.edu.springframework.messagesender.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import com.nhnacademy.edu.springframework.messagesender.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlMain {
    public static void main(String[] args) {
        //빈 객체의 생명주기
        String location = "classpath:/beans.xml";
        //
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(location);

        EmailMessageSender emailMessageSender = context.getBean("emailMessageSender", EmailMessageSender.class);
        SmsMessageSender smsMessageSender = context.getBean("smsMessageSender", SmsMessageSender.class);

        User user = new User("4df@sd.com", "123-342");
        String message = "hello";

        emailMessageSender.sendMessage(user, message);
        smsMessageSender.sendMessage(user, message);

        //context 종료 :스프링 빈들 전부 종료
    }
}
