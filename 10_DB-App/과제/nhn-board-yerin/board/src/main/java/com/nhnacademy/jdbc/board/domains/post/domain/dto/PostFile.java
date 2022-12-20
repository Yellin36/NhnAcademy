package com.nhnacademy.jdbc.board.domains.post.domain.dto;

import com.nhnacademy.jdbc.board.domains.file.domain.File;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostFile {
    private final Long id;
    private final String title;
    private final String content;
    private final List<File> files;
}
