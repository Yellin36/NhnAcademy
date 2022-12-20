package com.nhnacademy.springmvc.domain;

public enum PostType {
    COMPLAIN("불만"),
    PROPOSAL("제안"),
    REFUND_EXCHANGE("환불/교환"),
    COMPLIMENT("칭찬"),
    OTHERS("기타");

    private final String postType;

    PostType(String postType) {
        this.postType = postType;
    }

    public String getPostType() {
        return this.postType;
    }
}
