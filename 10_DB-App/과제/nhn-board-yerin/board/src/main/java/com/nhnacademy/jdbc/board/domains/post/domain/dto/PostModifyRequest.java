package com.nhnacademy.jdbc.board.domains.post.domain.dto;

import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Value
public class PostModifyRequest {
    @NotBlank
    @Length(min = 2, max = 200)
    String title;

    @NotBlank
    @Length(max = 10000)
    String content;

    List<MultipartFile> files;
    List<Long> deleteFiles;
}
