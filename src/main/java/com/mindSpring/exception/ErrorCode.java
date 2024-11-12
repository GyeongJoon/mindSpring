package com.mindSpring.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    MEMBER_NOT_FOUND("회원이 존재하지 않습니다.", "M1"),
    MEMBER_ALREADY_EXISTS("회원이 이미 존재합니다.","M2");

    private final String description;
    private final String id;

    ErrorCode(String description, String id) {
        this.description = description;
        this.id = id;
    }
}
