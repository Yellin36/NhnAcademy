package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.domains.post.domain.dto.PostComment;
import com.nhnacademy.jdbc.board.domains.post.service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardInquiryController {
    private final PostService postService;
    private final int TOTAL_COUNT = 20;


    public BoardInquiryController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public String inquiryPosts(Model model, HttpSession session) {
        session.setAttribute("category", "all");

        String content = (String) session.getAttribute("content");
        addPageAttributesInModel(model, 1, "all", content);

        return "board/list";
    }

    @GetMapping(params = "page")
    public String inquiryPosts(@RequestParam("page") Integer page,
                               HttpSession session,
                               Model model) {
        String category = (String) session.getAttribute("category");
        String content = (String) session.getAttribute("content");

        if (category.equals("like")) content = (String) session.getAttribute("sessionId");

        addPageAttributesInModel(model, page, category, content);

        return "board/list";
    }

    @PostMapping(params = {"search"})
    public String inquiryPostsWithTitle(@RequestParam("search") String search,
                                        HttpSession session,
                                        Model model) {
        session.setAttribute("category", "search");
        session.setAttribute("content", search);

        model.addAttribute("title", search);
        addPageAttributesInModel(model, 1, "title", search);

        return "board/list";
    }

    @GetMapping(params = {"category"})
    public String inquiryPostsWithCategory(@RequestParam("category") String category,
                                           HttpSession session,
                                           Model model) {
        session.setAttribute("category", category);

        String content = (String) session.getAttribute("content");
        if (category.equals("like")) content = (String) session.getAttribute("sessionId");

        addPageAttributesInModel(model, 1, category, content);
        return "board/list";
    }

    private void addPageAttributesInModel(Model model, Integer page, String option, String content) {
        List<PostComment> posts = null;
        int postSize = 0;

        switch (option) {
            case "all":
                posts = postService.getPostsWithCommentCount(page, TOTAL_COUNT);
                postSize = postService.getPostsCount();
                break;
            case "garage":
                posts = postService.getDeletedPostsWithCommentCount(page, TOTAL_COUNT);
                postSize = postService.getDeletedPostsCount();
                break;
            case "title":
                posts = postService.getSearchedPostsWithCommentCount(page, TOTAL_COUNT, content);
                postSize = postService.getPostsCountWithTitle(content);
                break;
            case "like":
                posts = postService.getLikePostsWithCommentCount(page, TOTAL_COUNT, content);
                postSize = postService.getPostsCountWithLike();
                break;
            default:
                throw new RuntimeException("Invalid Url");
        }

        int totalPageCount = (postSize - 1) / TOTAL_COUNT + 1;

        model.addAttribute("posts", posts);
        model.addAttribute("curPage", page);
        model.addAttribute("totalPage", totalPageCount);
    }
}
