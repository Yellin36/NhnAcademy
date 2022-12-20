package com.nhnacademy.springmvc.validator;

import com.nhnacademy.springmvc.domain.PostRegisterRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Slf4j
@Component
public class PostValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(PostRegisterRequest.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "", "title is empty");

        PostRegisterRequest request = (PostRegisterRequest) target;

        String title = request.getTitle();
        String content = request.getContent();

        checkTitleValidation(errors, title);
        checkContentValidation(errors, content);
    }

    private void checkContentValidation(Errors errors, String content) {
        if (content.length() > 40000) {
            log.info("content {}", content.length());
            errors.rejectValue("title", "", "내용은 40000자 제한입니다.");
        }
    }

    private void checkTitleValidation(Errors errors, String title) {
        if (title.length() < 2 || title.length() > 200) {
            log.info("title {}", title.length());
            errors.rejectValue("title", "", "제목은 2~200자 제한입니다.");
        }
    }
}
