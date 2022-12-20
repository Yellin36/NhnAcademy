package com.nhnacademy.springmvc.domain;

import lombok.Value;
import org.hibernate.validator.constraints.Length;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Value
public class PostRegisterRequest {
    String title;

    String postType;

    String content;

    List<MultipartFile> files;
}
