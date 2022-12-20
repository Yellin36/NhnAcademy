package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Answer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class InquiryAnswerRepository implements AnswerRepository {
    private final Map<Long, Answer> answerMap = new HashMap<>();

    @Override
    public Answer register(String writer, String writeTime, String content) {
        long id = answerMap.keySet()
                .stream()
                .max(Comparator.comparing(Function.identity()))
                .map(l -> l + 1)
                .orElse(1L);

        Answer answer = new Answer(id, writer, writeTime, content);

        answerMap.put(id, answer);

        return answer;
    }

    @Override
    public boolean exists(long id) {
        return answerMap.containsKey(id);
    }

    @Override
    public Answer getAnswer(long id) {
        if (!exists(id)) {
            return null;
        }
        return answerMap.get(id);
    }
}
