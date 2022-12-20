package com.nhnacademy.jdbc.board.domains.post.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class Post {
    private final Long id;
    private final String userId;
    private final String title;
    private final String content;
    private final Date createdAt;
    private final String modifier;
    private final Date updatedAt;
    private final boolean deleted;
}
