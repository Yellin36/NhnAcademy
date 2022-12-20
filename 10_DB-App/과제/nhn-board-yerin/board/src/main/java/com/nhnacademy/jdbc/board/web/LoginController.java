package com.nhnacademy.jdbc.board.web;

import com.nhnacademy.jdbc.board.domains.user.domain.User;
import com.nhnacademy.jdbc.board.domains.user.domain.dto.UserLoginRequest;
import com.nhnacademy.jdbc.board.domains.user.service.UserService;
import com.nhnacademy.jdbc.board.exception.InvalidUserException;
import com.nhnacademy.jdbc.board.exception.LoginFailedException;
import com.nhnacademy.jdbc.board.exception.ValidationFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String loginForm() {
        return "loginForm";
    }

    @PostMapping
    public String login(@Valid @ModelAttribute UserLoginRequest request,
                        BindingResult bindingResult,
                        HttpSession session) {
        if (bindingResult.hasErrors()) {
            throw new ValidationFailedException(bindingResult);
        }

        User user = userService.getUser(request.getId())
                .orElseThrow(() -> {
                    throw new InvalidUserException(request.getId());
                });

        if (!user.getPassword().equals(request.getPassword())) {
            throw new LoginFailedException(request.getPassword());
        }
        session.setAttribute("sessionId", request.getId());
        session.setAttribute("name", user.getName());
        session.setAttribute("authority", request.getAuthority());

        return "index";
    }
}
