package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.controller.ControllerBase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = ControllerBase.class)
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        //외부 사용자의 접근을 막기 위해 WEB-INF 하위에 view 생성 후 파일 접근
        registry.jsp("/WEB-INF/view/", ".jsp");
    }
}