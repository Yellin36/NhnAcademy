package com.nhnacademy.edu.springframework.config;

import com.nhnacademy.edu.springframework.messagesender.DoorayMessageSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nhnacademy.edu.springframework.messagesender")
@PropertySource("classpath:/dooray.properties")
public class DoorayConfig {
    @Bean
    public DoorayMessageSender doorayMessageSender() {
        return new DoorayMessageSender();
    }
}
