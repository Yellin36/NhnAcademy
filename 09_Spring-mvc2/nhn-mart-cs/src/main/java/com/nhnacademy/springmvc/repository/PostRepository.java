package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Post;
import com.nhnacademy.springmvc.domain.PostType;

import java.util.List;

public interface PostRepository {
    Post register(String title, PostType postType, String writer, String writeTime, List<String> fileNames, String content);
    boolean exists(long id);
    Post getPost(long id);
    List<Post> getPostsByWriter(String writer);
    List<Post> getPostsByAnswer();
    List<Post> getPostsByAnswer(PostType postType);
}
