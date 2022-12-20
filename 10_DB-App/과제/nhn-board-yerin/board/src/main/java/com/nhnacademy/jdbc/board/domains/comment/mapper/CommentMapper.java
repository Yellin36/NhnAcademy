package com.nhnacademy.jdbc.board.domains.comment.mapper;

import com.nhnacademy.jdbc.board.domains.comment.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    int getCommentCountByPostId(@Param("postId") long postId);

    List<Comment> selectCommentsByPostId(@Param("postId") long postId);

    void insertComment(@Param("postId") long postId, @Param("writer") String writer, @Param("content") String content);

    void updateComment(@Param("commentId") long commentId, @Param("content") String content);

    void deleteByPostId(@Param("postId") long postId);

    Comment selectCommentById(@Param("id") long commentId);

    void deleteById(@Param("id") long commentId);
}
