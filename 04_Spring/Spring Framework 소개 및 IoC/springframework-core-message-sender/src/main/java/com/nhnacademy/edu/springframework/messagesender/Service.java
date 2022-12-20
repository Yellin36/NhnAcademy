package com.nhnacademy.edu.springframework.messagesender;

import com.nhnacademy.edu.springframework.annotation.SMS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Service {
    public Service() {}
    private MessageSender messageSender;

    @Value("${from}")
    String name;
    //@Required
    @Autowired
    public Service(@SMS MessageSender messageSender, @Value("${mail.subject}") String subject) {
        this.messageSender = messageSender;
    }
    public Service(MessageSender messageSender) {
        this.messageSender = messageSender;
    }



    public String send(User user, String message) {
        System.out.println("[" + name + "]");

        return messageSender.sendMessage(user, message);

    }
}
