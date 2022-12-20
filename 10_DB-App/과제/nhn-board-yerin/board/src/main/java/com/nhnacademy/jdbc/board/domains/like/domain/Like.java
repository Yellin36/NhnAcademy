package com.nhnacademy.jdbc.board.domains.like.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@AllArgsConstructor
@ToString
public class Like {
    private final long id;
    private final long postId;
    private final String userId;
    private final Date createdAt;
}
