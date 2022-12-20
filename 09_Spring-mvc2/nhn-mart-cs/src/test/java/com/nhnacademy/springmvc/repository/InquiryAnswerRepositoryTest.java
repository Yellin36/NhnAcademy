package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Answer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InquiryAnswerRepositoryTest {
    InquiryAnswerRepository inquiryAnswerRepository;

    @BeforeEach
    void setUp() {
        inquiryAnswerRepository = new InquiryAnswerRepository();
    }

    @Test
    void register_success() {
        String writer = "admin@1";
        String writeTime = "2022-11-20";
        String content = "content";

        Answer result = inquiryAnswerRepository.register(writer, writeTime, content);

        assertThat(result).isNotNull();
        assertThat(result.getWriter()).isEqualTo(writer);
        assertThat(result.getContent()).isEqualTo(content);
        assertThat(result.getWriteTime()).isEqualTo(writeTime);
    }

    @Test
    void exists_false() {
        long id = 10;

        assertThat(inquiryAnswerRepository.exists(id)).isFalse();
    }

    @Test
    void exists_true() {
        String writer = "admin@1";
        String writeTime = "2022-11-20";
        String content = "content";

        Answer result = inquiryAnswerRepository.register(writer, writeTime, content);

        assertThat(inquiryAnswerRepository.exists(result.getId())).isTrue();
    }

    @Test
    void getAnswer_fail_returnNull() {
        long id = 10;

        assertThat(inquiryAnswerRepository.getAnswer(id)).isNull();
    }

    @Test
    void getAnswer_success() {
        String writer = "admin@1";
        String writeTime = "2022-11-20";
        String content = "content";

        Answer result = inquiryAnswerRepository.register(writer, writeTime, content);

        assertThat(inquiryAnswerRepository.getAnswer(result.getId())).isNotNull();
        assertThat(inquiryAnswerRepository.getAnswer(result.getId())).isEqualTo(result);
    }
}