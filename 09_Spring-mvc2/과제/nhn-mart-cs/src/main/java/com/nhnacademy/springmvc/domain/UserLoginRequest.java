package com.nhnacademy.springmvc.domain;

import lombok.Value;

@Value
public class UserLoginRequest {
    String option;
    String id;
    String password;
}
