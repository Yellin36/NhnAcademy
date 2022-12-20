package com.nhnacademy.jdbc.board.domains.like.mapper;

import com.nhnacademy.jdbc.board.domains.like.domain.Like;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LikeMapper {
    Optional<Integer> getLikeCountByPostId(@Param("postId") Long postId);

    Like selectCount(@Param("postId") long postId, @Param("userId") String userId);

    List<Like> selectCounts(@Param("postId") long postId);

    void insertLike(@Param("postId") long postId, @Param("userId") String userId);

    void deleteLike(@Param("postId") long postId, @Param("userId") String userId);

    void deleteByPostId(@Param("postId") long postId);
}
