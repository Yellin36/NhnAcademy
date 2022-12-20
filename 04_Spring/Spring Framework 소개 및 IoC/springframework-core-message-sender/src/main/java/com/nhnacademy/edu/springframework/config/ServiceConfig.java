package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.messagesender.Service;
import com.nhnacademy.edu.springframework.messagesender.SmsMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework")
@PropertySource("classpath:/sender.properties")
public class ServiceConfig {
//    private final SmsMessageSender smsMessageSender;
//
//    public ServiceConfig(SmsMessageSender smsMessageSender) {
//        this.smsMessageSender = smsMessageSender;
//    }
    @Autowired
    public MainConfig mainConfig;
    @Bean
    public Service service() {
        return new Service(mainConfig.smsMessageSender());
    }
}
