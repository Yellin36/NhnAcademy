package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.domains.like.service.LikeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LikeControllerTest {
    MockMvc mockMvc;
    LikeService likeService;

    @BeforeEach
    void setUp() {
        likeService = mock(LikeService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new LikeController(likeService)).build();
    }

    @Test
    void likeProcess() throws Exception {
        String sessionId = "sessionId";
        long postId = 1L;

        when(likeService.likes(postId, sessionId)).thenReturn(true);

        mockMvc.perform(get("/like/{postId}", postId)
                        .sessionAttr("sessionId", sessionId))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/board/" + postId));
    }
}