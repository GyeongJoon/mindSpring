package com.mindSpring.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {

    MEMBER_NOT_FOUND("회원이 존재하지 않습니다.", "M1"),
    MEMBER_ALREADY_EXISTS("회원이 이미 존재합니다.","M2"),
    INVALID_PASSWORD("비밀번호가 다릅니다.","P1"),
    INVALID_INPUT("잘못된 입력값입니다.","P1" ),
    CATEGORY_NOT_FOUND("카테고리가 존재하지 않습니다.", "CA1"),
    WORRY_NOT_FOUND("고민이 존재하지 않습니다.","W1"),
    INVALID_PAGEABLE("해당 페이지가 없습니다.","P1"),
    COUNSELOR_NOT_FOUND("상담사가 존재하지 않습니다.","CO1"),
    REVIEW_NOT_FOUND("리뷰가 존재하지 않습니다.", "R1"),
    AIANSWER_NOT_FOUND("AI답변이 존재하지 않습니다.", "A1"),
    OPENAI_API_ERROR("AI답변 오류", "A2");

    private final String description;
    private final String id;

    ErrorCode(String description, String id) {
        this.description = description;
        this.id = id;
    }
}
