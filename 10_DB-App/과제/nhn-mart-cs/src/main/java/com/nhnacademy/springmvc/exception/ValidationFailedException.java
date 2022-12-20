package com.nhnacademy.springmvc.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

@Slf4j
public class ValidationFailedException extends RuntimeException {
    public ValidationFailedException(BindingResult bindingResult) {
        super(bindingResult.getAllErrors()
                .stream()
                .map(error -> new StringBuilder()
                        .append(error.getObjectName())
                        .append(" [입력오류] ").append(error.getDefaultMessage()))
                .collect(Collectors.joining(" | ")));
    }
}
