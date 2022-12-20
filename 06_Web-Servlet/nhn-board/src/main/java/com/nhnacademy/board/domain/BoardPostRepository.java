package com.nhnacademy.board.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;

public class BoardPostRepository implements PostRepository, Serializable {
    private Map<Long, Post> posts = new ConcurrentHashMap<>();
    @Override
    public long register(Post post) {
        long postId = post.getId();

        if(this.posts.containsKey(postId)) {
            throw new IllegalArgumentException("Duplicate Posts");
        }
        this.posts.put(postId, post);

        return postId;
    }

    @Override
    public void modify(Post post) {
        long postId = post.getId();

        if(!this.posts.containsKey(postId)) {
            throw new NoSuchElementException("No Such Post");
        }
        this.posts.replace(postId, this.posts.get(postId), post);
    }

    @Override
    public Post remove(long id) {
        if(!this.posts.containsKey(id)) {
            throw new NoSuchElementException("No Such Post");
        }
        return this.posts.get(id);
    }

    @Override
    public Post getPost(long id) {
        if(!this.posts.containsKey(id)) {
            throw new NoSuchElementException("No Such Post");
        }
        return this.posts.get(id);
    }

    @Override
    public List<Post> getPosts() {
        return new ArrayList<>(this.posts.values());
    }
}
