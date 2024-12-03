package com.mindSpring.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseMessage<T> {
    private String status; // success 또는 error
    private String message; // 사용자 메시지
    private T data; // 응답 데이터

    public ResponseMessage(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
