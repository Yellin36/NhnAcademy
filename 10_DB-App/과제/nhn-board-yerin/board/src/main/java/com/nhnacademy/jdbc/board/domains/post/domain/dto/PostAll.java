package com.nhnacademy.jdbc.board.domains.post.domain.dto;

import com.nhnacademy.jdbc.board.domains.comment.domain.Comment;
import com.nhnacademy.jdbc.board.domains.file.domain.File;
import com.nhnacademy.jdbc.board.domains.like.domain.Like;
import com.nhnacademy.jdbc.board.domains.post.domain.Post;
import com.nhnacademy.jdbc.board.domains.reply.domain.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PostAll {
    private final Post post;
    private final List<Like> likes;
    private final List<File> files;
    private final List<Comment> comments;
    private final List<Reply> replies;

}
