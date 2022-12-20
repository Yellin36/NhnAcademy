package com.nhnacademy.springmvc.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

@Getter
public class Post {
    private final long id;
    private final String title;
    private final PostType postType;
    private final String writer;
    private final String writeTime;
    private List<String> files;
    @Setter
    private String content;
    @Setter
    private Long answerId;

    public Post(long id, String title, PostType postType, String writer, String writeTime, List<String> files, String content) {
        this.id = id;
        this.title = title;
        this.postType = postType;
        this.writer = writer;
        this.writeTime = writeTime;
        this.files = files;
        this.content = content;
        this.answerId = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return id == post.id && Objects.equals(title, post.title) && postType == post.postType && Objects.equals(writer, post.writer) && Objects.equals(writeTime, post.writeTime) && Objects.equals(files, post.files) && Objects.equals(content, post.content) && Objects.equals(answerId, post.answerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, postType, writer, writeTime, files, content, answerId);
    }
}
