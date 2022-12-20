package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.domains.comment.domain.Comment;
import com.nhnacademy.jdbc.board.domains.comment.service.CommentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class CommentControllerTest {
    MockMvc mockMvc;

    CommentService commentService;

    @BeforeEach
    void setUp() {
        commentService = mock(CommentService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new CommentController(commentService)).build();
    }

    @Test
    void registerComment() throws Exception {
        long postId = 1;
        String id = "user";
        String content = "content";

        mockMvc.perform(post("/comment/{postId}", postId)
                        .sessionAttr("sessionid", id)
                        .param("content", content))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/" + postId));
    }

    @Test
    void modifyCommentForm() throws Exception {
        long commentId = 1;
        Comment comment = new Comment(1L, 1L, "user", "content", new Date(), new Date());

        when(commentService.getComment(commentId)).thenReturn(comment);

        MvcResult result = mockMvc.perform(get("/comment/{commentId}/modify", commentId))
                .andExpect(status().isOk())
                .andExpect(view().name("board/commentModifyForm"))
                .andReturn();

        assertThat(result.getModelAndView().getModel().get("comment")).isEqualTo(comment);

    }

    @Test
    void testModifyComment() throws Exception {
        long commentId = 1L;
        long postId = 1L;
        String content = "content";

        when(commentService.updateComment(commentId, content)).thenReturn(postId);

        mockMvc.perform(post("/comment/{commentId}/modify", commentId)
                        .param("content", "content"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/" + postId));

        verify(commentService, times(1)).updateComment(anyLong(), anyString());
    }

    @Test
    void deleteComment() throws Exception {
        long commentId = 1L;
        long postId = 1L;
        Comment comment = new Comment(1L, 1L, "user", "content", new Date(), new Date());

        when(commentService.getComment(commentId)).thenReturn(comment);

        mockMvc.perform(get("/comment/{commentId}/delete", commentId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/" + postId));

        verify(commentService, times(1)).getComment(anyLong());
    }
}