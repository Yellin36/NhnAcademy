package com.nhnacademy.edu.springframework.messagesender;

public interface MessageSender {
    public String sendMessage(User user, String message);
    public void init();
    public void destroy();
}
