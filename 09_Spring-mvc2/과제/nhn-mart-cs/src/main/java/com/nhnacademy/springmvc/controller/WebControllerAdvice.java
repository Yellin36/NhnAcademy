package com.nhnacademy.springmvc.controller;

import com.nhnacademy.springmvc.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class WebControllerAdvice {
    @ExceptionHandler(LoginFailedException.class)
    public String handleLoginFailedException(Exception ex, Model model) {
        sendErrorMessage(model, ErrorCode.LOGIN_FAIL, ex.getMessage());

        return "error";
    }

    @ExceptionHandler(InvalidAuthorAccessException.class)
    public String invalidAuthorAccessHandlerException(Exception ex, Model model) {
        sendErrorMessage(model, ErrorCode.INVALID_AUTH_ACCESS, ex.getMessage());

        return "error";
    }

    @ExceptionHandler(ValidationFailedException.class)
    public String handlerValidationFailedException(Exception ex, Model model) {
        model.addAttribute("exception", ex.getMessage());

        return "error";
    }

    @ExceptionHandler(InvalidPostAccessException.class)
    public String loginFailedHandlerException(Exception ex, Model model) {
        sendErrorMessage(model, ErrorCode.INVALID_POST_NUM, ex.getMessage());

        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String handlerAllException(Exception ex, Model model) {
        sendErrorMessage(model, ErrorCode.PAGE_NOT_FOUND, ex.getMessage());

        return "error";
    }

    private void sendErrorMessage(Model model, ErrorCode code, String message) {
        String exception = message +
                " [" + code.getHttpStatus() + "] " +
                code.getMessage();

        model.addAttribute("exception", exception);
    }

}
