package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.messagesender.EmailMessageSender;
import com.nhnacademy.edu.springframework.messagesender.MessageSender;
import com.nhnacademy.edu.springframework.messagesender.Service;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration()
public class MainConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MessageSender smsMessageSender() {
        return new SmsMessageSender();
    }
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public MessageSender emailMessageSender() {
        return new EmailMessageSender();
    }
}

