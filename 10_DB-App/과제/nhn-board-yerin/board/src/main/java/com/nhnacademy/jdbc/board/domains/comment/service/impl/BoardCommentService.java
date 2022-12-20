package com.nhnacademy.jdbc.board.domains.comment.service.impl;

import com.nhnacademy.jdbc.board.domains.comment.domain.Comment;
import com.nhnacademy.jdbc.board.domains.comment.mapper.CommentMapper;
import com.nhnacademy.jdbc.board.domains.comment.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardCommentService implements CommentService {
    private final CommentMapper commentMapper;

    public BoardCommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public List<Comment> getCommentsByPostId(long postId) {
        return commentMapper.selectCommentsByPostId(postId);
    }

    @Override
    public Comment getComment(long commentId) {
        return commentMapper.selectCommentById(commentId);
    }

    @Override
    public void insertComment(long postId, String writer, String content) {
        commentMapper.insertComment(postId, writer, content);
    }

    @Override
    public long updateComment(long commentId, String content) {
        commentMapper.updateComment(commentId, content);
        return commentMapper.selectCommentById(commentId).getPostId();
    }

    @Override
    public void deleteComment(long commentId) {
        commentMapper.deleteById(commentId);
    }


}
