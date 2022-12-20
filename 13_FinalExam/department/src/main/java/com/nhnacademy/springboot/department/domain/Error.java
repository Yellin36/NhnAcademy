package com.nhnacademy.springboot.department.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Error {
    private LocalDateTime timestamp;
    private String status;
    private String error;
}
