package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostAll;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostFile;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostModifyRequest;
import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostRegisterRequest;
import com.nhnacademy.jdbc.board.domains.post.service.PostService;
import com.nhnacademy.jdbc.board.exception.InvalidPostAccessException;
import com.nhnacademy.jdbc.board.exception.ValidationFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {
    private final PostService postService;

    public BoardController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/register")
    public String registerPostForm() {
        return "board/registerForm";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute PostRegisterRequest request,
                               BindingResult bindingResult,
                               HttpSession session) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        String userId = (String) session.getAttribute("sessionId");

        postService.insertPost(userId,
                request.getTitle(),
                request.getContent(),
                request.getFiles());

        return "redirect:/board";
    }

    @GetMapping("/{postId}")
    public String showPostDetail(@PathVariable("postId") Long postId,
                                 HttpSession session,
                                 Model model) {
        checkExistsPost(postId);

        PostAll post = postService.getPostContainAll(postId);

        String userId = (String) session.getAttribute("sessionId");

        boolean like = post.getLikes()
                .stream()
                .anyMatch(x -> x.getUserId().equals(userId));

        model.addAttribute("like", like);
        model.addAttribute("post", post);

        return "board/view";
    }

    @GetMapping("/{postId}/modify")
    public String modifyPostForm(@PathVariable("postId") Long postId,
                                 Model model) {
        checkExistsPost(postId);

        PostFile post = postService.getPostContainFiles(postId);

        model.addAttribute("post", post);

        return "board/modifyForm";
    }

    @PostMapping("/{postId}/modify")
    public String modifyPost(@PathVariable("postId") Long postId,
                             @Valid @ModelAttribute PostModifyRequest request,
                             BindingResult bindingResult,
                             HttpSession session) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        checkExistsPost(postId);

        String modifier = (String) session.getAttribute("sessionId");
        List<String> insertFiles = request.getFiles()
                .stream()
                .map(x -> x.getOriginalFilename()).collect(Collectors.toList());

        postService.modifyPost(postId,
                request.getTitle(),
                request.getContent(),
                modifier,
                insertFiles,
                request.getDeleteFiles());

        return "redirect:/board/" + postId;
    }


    @GetMapping("/{postId}/delete")
    public String deletePost(@PathVariable("postId") Long postId) {
        checkExistsPost(postId);

        postService.deletePostById(postId);

        return "redirect:/board";
    }

    private void checkExistsPost(Long postId) {
        if (!postService.exists(postId)) {
            throw new InvalidPostAccessException(postId);
        }
    }
}
