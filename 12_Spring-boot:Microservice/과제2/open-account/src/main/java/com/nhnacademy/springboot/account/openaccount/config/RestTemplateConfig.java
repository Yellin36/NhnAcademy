package com.nhnacademy.springboot.account.openaccount.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class RestTemplateConfig {
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        //커넥션 풀을 활용하여 새로새로 만들지 말고 연결해서 사용하는 방식으로 사용할 것
        //응답이 안오면 timeout을 설정하여 막기
        return builder
                .setReadTimeout(Duration.ofSeconds(3L))
                .setConnectTimeout(Duration.ofSeconds(3L))
                .build();

    }
}
