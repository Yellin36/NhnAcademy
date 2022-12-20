package com.nhnacademy.jdbc.board.domains.post.domain.dto;

import lombok.Value;

@Value
public class PostInsertForm {
    private final Long id;
    private final String userId;
    private final String title;
    private final String content;
}
