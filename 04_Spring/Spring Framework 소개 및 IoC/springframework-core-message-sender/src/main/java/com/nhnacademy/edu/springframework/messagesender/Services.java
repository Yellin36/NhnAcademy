package com.nhnacademy.edu.springframework.messagesender;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Services {
    private List<MessageSender> messageSenders;

    public Services() {}


    //@Required

    public Services(List<MessageSender> messageSenders) {

        this.messageSenders = messageSenders;
    }

    @Autowired
    public void setMessageSender(List<MessageSender> messageSenders) {  //autowire="byName"에서 호출
        System.out.println("set by setMessageSender");
        this.messageSenders = messageSenders;
    }
    public void send(User user, String message) {
        //messageSender.sendMessage(user, message);
        for (int i = 0; i < messageSenders.size(); i++) {
            messageSenders.get(i).sendMessage(user, message);
        }
    }
}
