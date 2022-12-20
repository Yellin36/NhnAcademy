package com.nhnacademy.jdbc.board.domains.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class User {
    private final String userId;
    private final String password;
    private final String name;
    private final int authority;
    private final Date createdAt;
}
