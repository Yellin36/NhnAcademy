package com.nhnacademy.edu.springboot.account.adapter.in;

import com.nhnacademy.edu.springboot.account.config.SystemVersionProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SystemController {
    private final SystemVersionProperties systemVersionProperties;


    @GetMapping("/system/version")
    public String getVersion() {
        return "application(new!!) : {\"version\":\"" + systemVersionProperties.getVersion() + "\"}";
    }

}
