package com.nhnacademy.edu.springboot.student.adaptor.in;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome(Map model) {
        model.put("message", "welcome to the world");
        return "welcome";
    }

}
