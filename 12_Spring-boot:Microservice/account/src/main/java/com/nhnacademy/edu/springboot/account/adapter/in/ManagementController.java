package com.nhnacademy.edu.springboot.account.adapter.in;

import com.nhnacademy.edu.springboot.account.actuator.health.CustomHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagementController {
    private final CustomHealthIndicator customHealthIndicator;

    @PostMapping("/management/fail")
    public String maintenance() {
        customHealthIndicator.setUp(false);
        return "OK";
    }

    @PostMapping("/management/success")
    public String success() {
        customHealthIndicator.setUp(true);
        return "OK";
    }
}
