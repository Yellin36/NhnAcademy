package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.domain.Answer;
import com.nhnacademy.springmvc.domain.Post;
import com.nhnacademy.springmvc.domain.PostRegisterRequest;
import com.nhnacademy.springmvc.domain.PostType;
import com.nhnacademy.springmvc.exception.InvalidPostAccessException;
import com.nhnacademy.springmvc.exception.ValidationFailedException;
import com.nhnacademy.springmvc.repository.AnswerRepository;
import com.nhnacademy.springmvc.repository.PostRepository;
import com.nhnacademy.springmvc.validator.PostValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/customer")
public class CustomerController {
    private final PostRepository postRepository;
    private final AnswerRepository answerRepository;
    private final PostValidator validator;


    public CustomerController(PostRepository postRepository, AnswerRepository answerRepository, PostValidator validator) {
        this.postRepository = postRepository;
        this.answerRepository = answerRepository;
        this.validator = validator;
    }

    @GetMapping("/list")
    public String showInquiryLists(HttpSession session, Model model) {
        String writer = (String) session.getAttribute("sessionId");

        List<Post> userPosts = postRepository.getPostsByWriter(writer);

        model.addAttribute("posts", userPosts);

        return "customer/inquiryList";
    }

    @GetMapping("/list/{postId}")
    public String showInquiryDetailView(@PathVariable("postId") Long postId, Model model) {
        Post post = getInquiryPost(postId);
        Answer answer = getInquiryAnswerByPost(post);

        model.addAttribute("post", post);
        model.addAttribute("answer", answer);

        return "customer/inquiryView";
    }

    @GetMapping("/inquiry")
    public String showInquiryForm() {
        return "customer/inquiryForm";
    }

    @PostMapping("/inquiry")
    public String registerInquiry(@Validated @ModelAttribute PostRegisterRequest request,
                                  BindingResult bindingResult,
                                  @Value("${upload.dir}") String uploadDir,
                                  HttpSession session) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }
        PostType postType = PostType.valueOf(PostType.class, request.getPostType());
        String writer = (String) session.getAttribute("sessionId");
        String writeTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        List<String> fileNames = null;
        if(!request.getFiles().get(0).isEmpty()) {
            fileNames = request.getFiles().stream()
                    .map(x -> uploadDir + x.getOriginalFilename())
                    .collect(Collectors.toList());
        }

        postRepository.register(
                request.getTitle(),
                postType,
                writer,
                writeTime,
                fileNames,
                request.getContent()
        );

        return "redirect:/customer/list";
    }

    private Post getInquiryPost(Long postId) {
        if (!postRepository.exists(postId)) {
            throw new InvalidPostAccessException(postId);
        }
        return postRepository.getPost(postId);
    }

    private Answer getInquiryAnswerByPost(Post post) {
        Long answerId = post.getAnswerId();

        return (Objects.isNull(answerId)) ? null : answerRepository.getAnswer(answerId);
    }

    @InitBinder("postRegisterRequest")
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(validator);
    }

}
