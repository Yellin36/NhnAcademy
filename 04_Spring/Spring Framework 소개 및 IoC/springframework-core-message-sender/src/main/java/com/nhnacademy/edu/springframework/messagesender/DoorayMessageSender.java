package com.nhnacademy.edu.springframework.messagesender;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DoorayMessageSender implements MessageSender {

    @Override
    public void init() {
        System.out.println("DoorayMessageSender 생성");
    }

    @Override
    public void destroy() {
        System.out.println("DoorayMessageSender 제거");
    }

    @Value("${hookUrl}")
    private String hookUrl;

    @Value("${name}")
    private String name;

    @Value("${message}")
    private String totell;

    @Override
    public String sendMessage(User user, String message) {
        System.out.println(hookUrl +" " + name +" " + totell);
        new DoorayHookSender(new RestTemplate(), hookUrl)
                .send(DoorayHook.builder()
                        .botName(name)
                        .text(totell)
                        .build());
        return message;
    }
}
