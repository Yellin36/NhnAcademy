package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Answer;

public interface AnswerRepository {
    Answer register(String writer, String writeTime, String content);

    boolean exists(long id);

    Answer getAnswer(long id);
}
