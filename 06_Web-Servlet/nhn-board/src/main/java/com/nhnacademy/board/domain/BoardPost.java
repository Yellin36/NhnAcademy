package com.nhnacademy.board.domain;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BoardPost implements Post, Serializable {
    private long id;
    private String title;
    private String content;
    private String writerUserId;
    private LocalDateTime writeTime;
    private int viewCount;

    @Override
    public long getId() {
        return this.id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getWriterUserId() {
        return this.writerUserId;
    }

    @Override
    public void setWriterUserId(String writerUserId) {
        this.writerUserId = writerUserId;
    }

    @Override
    public LocalDateTime getWriteTime() {
        return this.writeTime;
    }

    @Override
    public void setWriteTime(LocalDateTime writeTime) {
        this.writeTime = writeTime;
    }

    @Override
    public int getViewCount() {
        return this.viewCount;
    }

    @Override
    public void increaseViewCount() {
        this.viewCount++;
    }
}
