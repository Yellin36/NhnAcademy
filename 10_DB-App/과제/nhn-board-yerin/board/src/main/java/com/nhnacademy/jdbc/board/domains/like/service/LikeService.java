package com.nhnacademy.jdbc.board.domains.like.service;

public interface LikeService {
    void addLike(long postId, String userId);

    void subtractLike(long postId, String userId);

    boolean likes(long postId, String userId);
}
