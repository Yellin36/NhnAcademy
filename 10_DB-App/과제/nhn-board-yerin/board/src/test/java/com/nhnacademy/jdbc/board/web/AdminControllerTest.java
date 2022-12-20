package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.domains.comment.domain.Comment;
import com.nhnacademy.jdbc.board.domains.file.domain.File;
import com.nhnacademy.jdbc.board.domains.like.domain.Like;
import com.nhnacademy.jdbc.board.domains.post.domain.Post;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostAll;
import com.nhnacademy.jdbc.board.domains.post.service.PostService;
import com.nhnacademy.jdbc.board.domains.reply.domain.Reply;
import com.nhnacademy.jdbc.board.exception.InvalidPostAccessException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.util.NestedServletException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AdminControllerTest {
    MockMvc mockMvc;

    PostService postService;

    @BeforeEach
    void setUp() {
        postService = mock(PostService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new AdminController(postService)).build();
    }

    @Test
    void showPostDetail_failedByInvalidPostId_thenThrowInvalidPostAccessException() {
        long postId = 1000;

        when(postService.deleted(postId)).thenReturn(false);

        Throwable th = catchThrowable(() ->
                mockMvc.perform(get("/admin/board/{postId}", postId))
        );

        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(InvalidPostAccessException.class);
    }

    @Test
    void showPostDetail_success() throws Exception {
        long postId = 1;
        PostAll postAll = getPostAllValue();

        when(postService.deleted(postId)).thenReturn(true);
        when(postService.getDeletedPostContainAll(postId)).thenReturn(postAll);

        MvcResult result = mockMvc.perform(get("/admin/board/{postId}", postId)
                .sessionAttr("sessionId", "user"))
                .andExpect(status().isOk())
                .andExpect(view().name("board/view"))
                .andReturn();
        assertThat(result.getModelAndView().getModel().get("post")).isEqualTo(postAll);
    }

    @Test
    void recoverPost_failedByInvalidPostId_thenThrowInvalidPostAccessException() {
        long postId = 1000;

        when(postService.deleted(postId)).thenReturn(false);

        Throwable th = catchThrowable(() ->
                mockMvc.perform(get("/admin/board/{postId}/recover", postId))
        );
        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(InvalidPostAccessException.class);
    }

    @Test
    void recoverPost_success() throws Exception {
        long postId = 1;

        when(postService.deleted(postId)).thenReturn(true);

        mockMvc.perform(get("/admin/board/{postId}/recover", postId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board"));

    }

    @Test
    void deletePostPermanently_failedByInvalidPostId_thenThrowInvalidPostAccessException() {
        long postId = 1000;

        when(postService.deleted(postId)).thenReturn(false);

        Throwable th = catchThrowable(() ->
                mockMvc.perform(get("/admin/board/{postId}/delete", postId))
        );
        assertThat(th).isInstanceOf(NestedServletException.class)
                .hasCauseInstanceOf(InvalidPostAccessException.class);
    }


    @Test
    void deletePostPermanently_success() throws Exception {
        long postId = 1;

        when(postService.deleted(postId)).thenReturn(true);

        mockMvc.perform(get("/admin/board/{postId}/delete", postId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board"));

    }

    PostAll getPostAllValue() {
        Post post = new Post(1L, "user", "title", "content", new Date(), "user2", new Date(), false);
        List<Like> likes = new ArrayList<>();
        List<File> files = new ArrayList<>();
        List<Comment> comments = new ArrayList<>();
        List<Reply> replies = new ArrayList<>();
        PostAll postAll = new PostAll(post, likes, files, comments, replies);

        return postAll;
    }
}