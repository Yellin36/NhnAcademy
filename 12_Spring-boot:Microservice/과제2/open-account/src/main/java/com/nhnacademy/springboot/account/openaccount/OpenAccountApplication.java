package com.nhnacademy.springboot.account.openaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ConfigurationPropertiesScan
public class OpenAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenAccountApplication.class, args);
    }

}
