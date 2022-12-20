package com.nhnacademy.jdbc.board.domains.file.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class File {
    private final Long id;
    private final long postId;
    private final String fileName;
    private final Date createdAt;
}
