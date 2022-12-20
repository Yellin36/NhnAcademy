package com.nhnacademy.jdbc.board.domains.like.service.impl;

import com.nhnacademy.jdbc.board.domains.like.mapper.LikeMapper;
import com.nhnacademy.jdbc.board.domains.like.service.LikeService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class BoardLikeService implements LikeService {
    private final LikeMapper likeMapper;

    public BoardLikeService(LikeMapper likeMapper) {
        this.likeMapper = likeMapper;
    }

    @Override
    public boolean likes(long postId, String userId) {
        return Objects.nonNull(likeMapper.selectCount(postId, userId));
    }


    @Override
    public void addLike(long postId, String userId) {
        likeMapper.insertLike(postId, userId);
    }

    @Override
    public void subtractLike(long postId, String userId) {
        likeMapper.deleteLike(postId, userId);
    }
}
