package com.nhnacademy.springmvc.domain;

import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class AnswerRegisterRequest {
    @Length(min = 1, max = 40000)
    String content;
}
