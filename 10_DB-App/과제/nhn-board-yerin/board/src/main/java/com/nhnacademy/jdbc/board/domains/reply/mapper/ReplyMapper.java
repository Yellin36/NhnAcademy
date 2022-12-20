package com.nhnacademy.jdbc.board.domains.reply.mapper;

import com.nhnacademy.jdbc.board.domains.reply.domain.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    List<Reply> selectRepliesByPostId(@Param("postId") long postId);
    void deleteRepliesByPostId(@Param("postId") long postId);
}
