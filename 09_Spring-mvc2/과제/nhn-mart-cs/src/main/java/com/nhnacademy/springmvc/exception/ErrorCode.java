package com.nhnacademy.springmvc.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
public enum ErrorCode {
    /* 400 BAD_REQUEST : 잘못된 요청 -> 존재하지 않는 포스트*/
    INVALID_USER(BAD_REQUEST, "존재하지 않는 사용자입니다."),
    INVALID_POST_NUM(BAD_REQUEST, "유효하지 않은 게시글입니다."),
    LOGIN_FAIL(BAD_REQUEST, "아이디/비밀번호를 다시 한 번 확인해주십시오."),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 -> 로그인 필요*/
    LOGIN_SESSION_NOT_FOUND(UNAUTHORIZED, "로그아웃된 사용자입니다."),


    /* 403 FORBIDDEN : 권한 없음 -> custoemr/amdin */
    INVALID_AUTH_ACCESS(FORBIDDEN, "접근 권한이 없습니다."),


    /* 404 NOT_FOUND : 없음 -> 존재하지않는 페이지 접근*/
    PAGE_NOT_FOUND(NOT_FOUND, "잘못된 접근 경로입니다."),

    /* 409 CONFLICT : 중복된 유저 데이터 존재 */
    ALREADY_REGISTERED_USER(CONFLICT, "이미 존재하는 아이디입니다.");

    private final HttpStatus httpStatus;
    private final String message;

    ErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
