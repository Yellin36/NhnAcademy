package com.nhnacademy.springmvc.domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Answer {
    private final long id;
    private final String writer;
    private final String writeTime;
    private final String content;

    public Answer(long id, String writer, String writeTime, String content) {
        this.id = id;
        this.writer = writer;
        this.writeTime = writeTime;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return id == answer.id && Objects.equals(writer, answer.writer) && Objects.equals(writeTime, answer.writeTime) && Objects.equals(content, answer.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, writer, writeTime, content);
    }
}
