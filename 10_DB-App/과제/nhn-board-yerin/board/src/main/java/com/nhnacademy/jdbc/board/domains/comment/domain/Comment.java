package com.nhnacademy.jdbc.board.domains.comment.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Comment {
    private final Long id;
    private final long postId;
    private final String writer;
    private final String content;
    private final Date createdAt;
    private final Date updatedAt;
}
