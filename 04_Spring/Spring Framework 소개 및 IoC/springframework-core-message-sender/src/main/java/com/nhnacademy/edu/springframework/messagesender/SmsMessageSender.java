package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.stereotype.Component;

@Component
public class SmsMessageSender implements MessageSender {
    public SmsMessageSender() {
        System.out.println("prototype--------------SmsMessageSender initiated!!");
    }
    
    public void init() {
        System.out.println("init method called in SmsMessageSender");
    }
    public void destroy() {
        System.out.println("destroy smsMessageSender ");
    }
    
    @Override
    public String sendMessage(User user, String message) {
        System.out.printf("SMS Message Sent to %s : %s\n", user.getPhoneNumber(), message);
        return message;
    }
}
