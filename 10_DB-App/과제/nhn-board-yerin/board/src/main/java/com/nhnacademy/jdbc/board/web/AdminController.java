package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostAll;
import com.nhnacademy.jdbc.board.domains.post.service.PostService;
import com.nhnacademy.jdbc.board.exception.InvalidPostAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin/board")
public class AdminController {
    private final PostService postService;

    public AdminController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/{postId}")
    public String showPostDetail(@PathVariable("postId") Long postId,
                                 HttpSession session,
                                 Model model) {
        checkDeletedPost(postId);

        PostAll post = postService.getDeletedPostContainAll(postId);

        String userId = (String) session.getAttribute("sessionId");

        boolean like = post.getLikes()
                .stream()
                .anyMatch(x -> x.getUserId().equals(userId));

        model.addAttribute("like", like);
        model.addAttribute("post", post);

        return "board/view";
    }

    @GetMapping("/{postId}/recover")
    public String recoverPost(@PathVariable("postId") Long postId) {
        checkDeletedPost(postId);

        postService.recoverPostById(postId);

        return "redirect:/board";
    }

    @GetMapping("/{postId}/delete")
    public String deletePostPermanently(@PathVariable("postId") Long postId) {
        checkDeletedPost(postId);

        postService.deletePostPermanentlyById(postId);

        return "redirect:/board";
    }

    private void checkDeletedPost(Long postId) {
        if (!postService.deleted(postId)) {
            throw new InvalidPostAccessException(postId);
        }
    }
}
