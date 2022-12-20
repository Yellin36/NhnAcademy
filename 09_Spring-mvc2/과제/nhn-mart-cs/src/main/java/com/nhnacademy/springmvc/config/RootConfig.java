package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.Base;
import com.nhnacademy.springmvc.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Slf4j
@Configuration
@ComponentScan(basePackageClasses = Base.class,
        excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {

    @Bean
    public UserRepository customerRepository() {
        UserRepository customerRepository = new CustomerRepository();

        customerRepository.registerUser("user@1", "1234", "김하나");
        customerRepository.registerUser("user@2", "1234", "이둘");
        customerRepository.registerUser("user@3", "1234", "박셋");

        log.info("customerRepository = {}", customerRepository);

        return customerRepository;
    }

    @Bean
    public UserRepository managerRepository() {
        UserRepository managerRepository = new ManagerRepository();

        managerRepository.registerUser("admin@1", "1234", "관리자1");
        managerRepository.registerUser("admin@2", "1234", "관리자2");
        managerRepository.registerUser("admin@3", "1234", "관리자3");
        log.info("managerRepository = {}", managerRepository);

        return managerRepository;
    }

    @Bean
    public PostRepository postRepository() {
        return new InquiryPostRepository();
    }

    @Bean
    public AnswerRepository answerRepository() {
        return new InquiryAnswerRepository();
    }

}
