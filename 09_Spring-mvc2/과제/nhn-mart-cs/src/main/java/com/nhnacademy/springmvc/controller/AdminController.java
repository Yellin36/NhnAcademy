package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Answer;
import com.nhnacademy.springmvc.domain.AnswerRegisterRequest;
import com.nhnacademy.springmvc.domain.Post;
import com.nhnacademy.springmvc.domain.PostType;
import com.nhnacademy.springmvc.exception.InvalidPostAccessException;
import com.nhnacademy.springmvc.exception.ValidationFailedException;
import com.nhnacademy.springmvc.repository.AnswerRepository;
import com.nhnacademy.springmvc.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {
    private final PostRepository postRepository;
    private final AnswerRepository answerRepository;

    public AdminController(PostRepository postRepository, AnswerRepository answerRepository) {
        this.postRepository = postRepository;
        this.answerRepository = answerRepository;
    }

    @GetMapping("/list")
    public String showManagerInquiryLists(Model model) {
        List<Post> userPosts = postRepository.getPostsByAnswer();

        model.addAttribute("posts", userPosts);

        return "admin/inquiryList";
    }

    @GetMapping(value = "/list", params = "type")
    public String showManagerInquiryListsWithType(@RequestParam String type, Model model) {
        PostType selectedPostType = PostType.valueOf(type);

        List<Post> userPosts = postRepository.getPostsByAnswer(selectedPostType);

        model.addAttribute("posts", userPosts);
        model.addAttribute("type", type);

        return "admin/inquiryList";
    }

    @GetMapping("/answer/{postId}")
    public String showInquiryAnswerForm(@PathVariable("postId") Long postId, Model model) {
        Post post = getInquiryPost(postId);

        model.addAttribute("post", post);

        return "admin/answerForm";
    }

    @PostMapping("/answer/{postId}")
    public String registerInquiryAnswer(@PathVariable("postId") Long postId,
                                        @Valid @ModelAttribute AnswerRegisterRequest request,
                                        BindingResult bindingResult,
                                        HttpSession session) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        Post post = getInquiryPost(postId);

        String writer = (String) session.getAttribute("sessionId");
        String writeTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Answer answer = answerRepository.register(writer, writeTime, request.getContent());

        post.setAnswerId(answer.getId());

        return "redirect:/admin/list";
    }

    private Post getInquiryPost(Long postId) {
        if (!postRepository.exists(postId)) {
            throw new InvalidPostAccessException(postId);
        }
        return postRepository.getPost(postId);
    }
}
