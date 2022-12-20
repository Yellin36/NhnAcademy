package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Post;
import com.nhnacademy.springmvc.domain.PostType;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class InquiryPostRepository implements PostRepository {
    private final Map<Long, Post> postMap = new HashMap<>();

    @Override
    public Post register(String title, PostType postType, String writer, String writeTime, List<String> files, String content) {
        long id = postMap.keySet()
                .stream()
                .max(Comparator.comparing(Function.identity()))
                .map(l -> l + 1)
                .orElse(1L);

        Post post = new Post(id, title, postType, writer, writeTime, files, content);

        postMap.put(id, post);

        return post;
    }

    @Override
    public boolean exists(long id) {
        return postMap.containsKey(id);
    }

    @Override
    public Post getPost(long id) {
        return (exists(id)) ? postMap.get(id) : null;
    }

    @Override
    public List<Post> getPostsByWriter(String writer) {
        return postMap.values().stream()
                .filter(post -> post.getWriter().equals(writer))
                .sorted((p1, p2) -> (int) (p2.getId() - p1.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostsByAnswer() {
        return postMap.values().stream()
                .filter(post -> post.getAnswerId() == null)
                .sorted((p1, p2) -> (int) (p2.getId() - p1.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> getPostsByAnswer(PostType postType) {
        return postMap.values().stream()
                .filter(post -> post.getAnswerId() == null && post.getPostType() == postType)
                .sorted((p1, p2) -> (int) (p2.getId() - p1.getId()))
                .collect(Collectors.toList());
    }

}
