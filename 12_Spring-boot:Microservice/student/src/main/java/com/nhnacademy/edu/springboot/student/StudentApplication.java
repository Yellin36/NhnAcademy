package com.nhnacademy.edu.springboot.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//@EnableConfigurationProperties({SystemAuthorProperties.class, SystemVersionProperties.class})
@ConfigurationPropertiesScan
public class StudentApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
//		SpringApplication.run(StudentApplication.class, args);
        SpringApplication springApplication = new SpringApplication(StudentApplication.class);
//		springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(StudentApplication.class);
    }
}
