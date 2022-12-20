package com.nhnacademy.jdbc.board.domains.post.service;

import com.nhnacademy.jdbc.board.domains.post.domain.Post;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostAll;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostComment;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author : marco@nhnacademy.com
 * @Date : 17/05/2022
 */
public interface PostService {
    boolean exists(Long postId);

    boolean deleted(Long postId);

    int getPostsCount();

    int getPostsCountWithLike();

    int getPostsCountWithTitle(String title);

    int getDeletedPostsCount();

    Post getExistPostByPostId(Long postId);

    PostAll getPostContainAll(Long postId);

    PostAll getDeletedPostContainAll(Long postId);

    PostFile getPostContainFiles(Long postId);

    List<PostComment> getPostsWithCommentCount(int page, int totalCount);

    List<PostComment> getDeletedPostsWithCommentCount(int page, int totalCount);

    List<PostComment> getLikePostsWithCommentCount(int page, int totalCount, String userId);

    List<PostComment> getSearchedPostsWithCommentCount(Integer page, int total_count, String title);

    void insertPost(String userId, String title, String content, List<MultipartFile> files);

    void modifyPost(Long postId, String title, String content, String modifier, List<String> insertFiles, List<Long> deleteFiles);

    void recoverPostById(Long postId);

    void deletePostById(long postId);


    void deletePostPermanentlyById(Long postId);

}
