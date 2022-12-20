package com.nhnacademy.edu.springframework.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.nhnacademy.edu.springframework.aop")
public class AopConfig {
    @Bean
    public MessageTimeAspect messageTimeAspect() {
        return new MessageTimeAspect();
    }

}
