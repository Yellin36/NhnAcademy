package com.nhnacademy.jdbc.board.domains.comment.service;

import com.nhnacademy.jdbc.board.domains.comment.domain.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsByPostId(long postId);

    Comment getComment(long commentId);

    void insertComment(long postId, String writer, String content);

    long updateComment(long commentId, String content);

    void deleteComment(long commentId);
}
