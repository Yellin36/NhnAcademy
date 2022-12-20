package com.nhnacademy.jdbc.board.domains.post.mapper;

import com.nhnacademy.jdbc.board.domains.post.domain.Post;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostInsertForm;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;


@Mapper
public interface PostMapper {
    int getPostCount(); //o

    int getPostCountWithLike();

    int getPostCountWithTitle(@Param("title") String title);

    int getDeletedPostsCount();

    List<Post> selectDeletedPosts(@Param("limit") int limit, @Param("offset") int offset);

    List<Post> selectExistPosts(@Param("limit") int limit, @Param("offset") int offset);

    List<Post> selectExistPostsWithLike(@Param("limit") int limit, @Param("offset") int offset, @Param("userId") String userId);

    List<Post> selectExistPostsWithTitle(@Param("limit") int limit, @Param("offset") int offset, @Param("title") String title);

    Optional<Post> selectExistPost(long id);

    Optional<Post> selectDeletedPost(@Param("id") Long postId);

    void insertPost(@Param("post") PostInsertForm post);

    void updatePost(@Param("postId") Long postId, @Param("title") String title, @Param("content") String content, @Param("modifier") String modifier);

    void deleteById(long id);

    void recoverById(long id);

    void deletePermanentlyById(long id);

}
