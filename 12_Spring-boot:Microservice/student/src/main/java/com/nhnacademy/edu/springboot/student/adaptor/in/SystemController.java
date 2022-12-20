package com.nhnacademy.edu.springboot.student.adaptor.in;

import com.nhnacademy.edu.springboot.student.config.SystemAuthorProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SystemController {
//    @Value("${system.author.name")
//    private String author;

    private final SystemAuthorProperties systemAuthorProperties;

    @GetMapping("/system/author")
    public String getAuthor() {
        return "Authdordion : " + systemAuthorProperties.getName();
    }

}
