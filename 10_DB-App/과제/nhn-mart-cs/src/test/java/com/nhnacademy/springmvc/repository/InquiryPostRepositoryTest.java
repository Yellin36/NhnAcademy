package com.nhnacademy.springmvc.repository;

import com.nhnacademy.springmvc.domain.Post;
import com.nhnacademy.springmvc.domain.PostType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InquiryPostRepositoryTest {

    InquiryPostRepository inquiryPostRepository;

    @BeforeEach
    void setUp() {
        inquiryPostRepository = new InquiryPostRepository();
    }

    @Test
    void register_success() {
        String title = "title";
        PostType postType = PostType.COMPLAIN;
        String writer = "user@1";
        String writeTime = "2022-11-20";
        String content = "content";

        Post result = inquiryPostRepository.register(title, postType, writer, writeTime, null, content);

        assertThat(result).isNotNull();
        assertThat(result.getTitle()).isEqualTo(title);
        assertThat(result.getPostType()).isEqualTo(postType);
        assertThat(result.getWriter()).isEqualTo(writer);
        assertThat(result.getContent()).isEqualTo(content);
        assertThat(result.getWriteTime()).isEqualTo(writeTime);
    }

    @Test
    void exists_false() {
        long id = 10;

        assertThat(inquiryPostRepository.exists(id)).isFalse();
    }

    @Test
    void exists_true() {
        String title = "title";
        PostType postType = PostType.COMPLAIN;
        String writer = "user@1";
        String writeTime = "2022-11-20";
        String content = "content";

        Post result = inquiryPostRepository.register(title, postType, writer, writeTime, null, content);

        assertThat(inquiryPostRepository.exists(result.getId())).isTrue();
    }

    @Test
    void getPost_fail_returnNull() {
        long id = 10;

        assertThat(inquiryPostRepository.getPost(id)).isNull();
    }

    @Test
    void getPost_success() {
        String title = "title";
        PostType postType = PostType.COMPLAIN;
        String writer = "user@1";
        String writeTime = "2022-11-20";
        String content = "content";

        Post post = inquiryPostRepository.register(title, postType, writer, writeTime, null, content);

        assertThat(inquiryPostRepository.getPost(post.getId())).isNotNull();
        assertThat(inquiryPostRepository.getPost(post.getId())).isEqualTo(post);
    }

    @Test
    void getPostsByWriter() {
        String title = "title";
        String writer = "user@1";
        PostType postType = PostType.COMPLAIN;
        String writeTime = "2022-11-20";
        String content = "content";

        for (int i = 0; i < 3; i++) {
            inquiryPostRepository.register(title + i, postType, writer, writeTime, null, content);
        }

        List<Post> result = inquiryPostRepository.getPostsByWriter(writer);

        assertThat(result).isNotNull();
        result.stream().map(Post::getWriter).forEach(x ->
                assertThat(x).isEqualTo(writer)
        );
    }

    @Test
    void getPostsByAnswer() {
        addUsers();

        List<Post> result = inquiryPostRepository.getPostsByAnswer();

        assertThat(result).isNotNull();
        result.stream().map(Post::getAnswerId).forEach(x ->
                assertThat(x).isNull()
        );
    }

    @ParameterizedTest
    @EnumSource(value = PostType.class)
    void getPostsByAnswerWithPostType(PostType postType) {
        addUsers();

        List<Post> result = inquiryPostRepository.getPostsByAnswer(postType);

        assertThat(result).isNotNull();
        result.stream().map(Post::getPostType).forEach(x ->
                assertThat(x).isEqualTo(postType)
        );
    }

    void addUsers() {
        String title = "title";
        String writer = "user@";
        String writeTime = "2022-11-20";
        String content = "content";

        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (PostType postType : PostType.values()) {
                inquiryPostRepository.register(title + count, postType, writer + count, writeTime, null, content);
                count++;
            }
        }
    }
}