package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.stereotype.Component;

@Component
public class EmailMessageSender implements MessageSender{
    int cnt=0;

    public EmailMessageSender() {
        System.out.println("singleton---------------EmailMessageSender initiated!!");
    }

    public void init() {
        System.out.println("init emailMessageSender");
    }
    public void destroy() {
        System.out.println("destroy method called in EmailMessageSender");
    }
    
    @Override
    public String sendMessage(User user, String message) {
        System.out.printf( "Email Message Sent %s : %s(%d)\n", user.getEmail(), message, cnt++);
        return message;
    }
}
