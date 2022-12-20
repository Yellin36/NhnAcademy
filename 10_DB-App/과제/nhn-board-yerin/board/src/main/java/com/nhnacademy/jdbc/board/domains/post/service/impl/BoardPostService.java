package com.nhnacademy.jdbc.board.domains.post.service.impl;

import com.nhnacademy.jdbc.board.domains.comment.domain.Comment;
import com.nhnacademy.jdbc.board.domains.comment.mapper.CommentMapper;
import com.nhnacademy.jdbc.board.domains.file.domain.File;
import com.nhnacademy.jdbc.board.domains.file.mapper.FileMapper;
import com.nhnacademy.jdbc.board.domains.like.domain.Like;
import com.nhnacademy.jdbc.board.domains.like.mapper.LikeMapper;
import com.nhnacademy.jdbc.board.domains.post.domain.Post;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostAll;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostComment;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostFile;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostInsertForm;
import com.nhnacademy.jdbc.board.domains.post.mapper.PostMapper;
import com.nhnacademy.jdbc.board.domains.post.service.PostService;
import com.nhnacademy.jdbc.board.domains.reply.domain.Reply;
import com.nhnacademy.jdbc.board.domains.reply.mapper.ReplyMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Slf4j
@Service
@Transactional
public class BoardPostService implements PostService {
    private final PostMapper postMapper;
    private final FileMapper fileMapper;
    private final CommentMapper commentMapper;
    private final LikeMapper likeMapper;
    private final ReplyMapper replyMapper;

    public BoardPostService(PostMapper postMapper, CommentMapper commentMapper, ReplyMapper replyMapper, LikeMapper likeMapper, FileMapper fileMapper) {
        this.postMapper = postMapper;
        this.commentMapper = commentMapper;
        this.replyMapper = replyMapper;
        this.likeMapper = likeMapper;
        this.fileMapper = fileMapper;
    }

    @Override
    public int getPostsCount() {
        return postMapper.getPostCount();
    }

    @Override
    public int getPostsCountWithLike() {
        return postMapper.getPostCountWithLike();
    }

    @Override
    public int getPostsCountWithTitle(String title) {
        return postMapper.getPostCountWithTitle(title);
    }

    @Override
    public int getDeletedPostsCount() {
        return postMapper.getDeletedPostsCount();
    }

    @Override
    public boolean exists(Long postId) {
        return postMapper.selectExistPost(postId).isPresent();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean deleted(Long postId) {
        return postMapper.selectDeletedPost(postId).isPresent();
    }

    @Override
    @Transactional(readOnly = true)
    public Post getExistPostByPostId(Long postId) {
        Post post = postMapper.selectExistPost(postId).get();
        return post;
    }

    @Override
    public List<PostComment> getSearchedPostsWithCommentCount(Integer page, int totalCount, String title) {
        int limit = totalCount;
        int offset = (page - 1) * totalCount;

        List<Post> posts = postMapper.selectExistPostsWithTitle(limit, offset, title);

        return getPostComments(posts);
    }

    @Override
    public List<PostComment> getPostsWithCommentCount(int page, int totalCount) {
        int limit = totalCount;
        int offset = (page - 1) * totalCount;

        List<Post> posts = postMapper.selectExistPosts(limit, offset);

        return getPostComments(posts);
    }

    @Override
    public List<PostComment> getDeletedPostsWithCommentCount(int page, int totalCount) {
        int limit = totalCount;
        int offset = (page - 1) * totalCount;

        List<Post> posts = postMapper.selectDeletedPosts(limit, offset);

        return getPostComments(posts);
    }

    @Override
    public List<PostComment> getLikePostsWithCommentCount(int page, int totalCount, String userId) {
        int limit = totalCount;
        int offset = (page - 1) * totalCount;

        List<Post> posts = postMapper.selectExistPostsWithLike(limit, offset, userId);

        return getPostComments(posts);
    }

    @Override
    public void insertPost(String userId, String title, String content, List<MultipartFile> files) {
        PostInsertForm post = new PostInsertForm(null, userId, title, content);

        postMapper.insertPost(post);

        Long postId = post.getId();

        if (files.get(0).isEmpty()) return;
        for (MultipartFile file : files) {
            fileMapper.insertFile(postId, file.getOriginalFilename());
        }
    }

    @Override
    public PostAll getPostContainAll(Long postId) {
        Post post = postMapper.selectExistPost(postId).get();
        PostAll postView = getPostAll(postId, post);

        return postView;
    }

    @Override
    public PostAll getDeletedPostContainAll(Long postId) {
        Post post = postMapper.selectDeletedPost(postId).get();
        PostAll postView = getPostAll(postId, post);

        return postView;
    }

    private PostAll getPostAll(Long postId, Post post) {
        List<File> files = fileMapper.selectFilesByPostId(postId);
        List<Like> likes = likeMapper.selectCounts(postId);
        List<Comment> comments = commentMapper.selectCommentsByPostId(postId);
        List<Reply> replies = null;

        PostAll postView = new PostAll(post, likes, files, comments, replies);
        return postView;
    }

    @Override
    public PostFile getPostContainFiles(Long postId) {
        Post post = postMapper.selectExistPost(postId).get();
        List<File> files = fileMapper.selectFilesByPostId(postId);

        PostFile postFile = new PostFile(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                files
        );

        return postFile;
    }


    @Override
    public void modifyPost(Long postId, String title, String content, String modifier, List<String> insertFiles, List<Long> deleteFiles) {
        postMapper.updatePost(postId, title, content, modifier);

        if (Objects.nonNull(deleteFiles)) {
            for (Long fileId : deleteFiles) {
                fileMapper.deleteFile(fileId);
            }
        }

        if (insertFiles.get(0).isEmpty()) return;
        for (String fileName : insertFiles) {
            fileMapper.insertFile(postId, fileName);
        }
    }

    @Override
    public void recoverPostById(Long postId) {
        postMapper.recoverById(postId);
    }

    @Override
    public void deletePostById(long postId) {
        postMapper.deleteById(postId);
    }

    @Override
    public void deletePostPermanentlyById(Long postId) {
        postMapper.deletePermanentlyById(postId);
    }

    private List<PostComment> getPostComments(List<Post> posts) {
        List<PostComment> postLists = new ArrayList<>();
        for (Post post : posts) {
            int commentCount = commentMapper.getCommentCountByPostId(post.getId());

            postLists.add(new PostComment(post.getId(),
                    post.getUserId(),
                    post.getTitle(),
                    post.getCreatedAt(),
                    post.getModifier(),
                    post.getUpdatedAt(),
                    commentCount));
        }
        return postLists;
    }
}
