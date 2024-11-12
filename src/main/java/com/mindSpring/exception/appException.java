package com.mindSpring.exception;

import lombok.Getter;

@Getter
public class appException extends RuntimeException {
    private final  ErrorCode errorCode;

    public appException(ErrorCode errorCode) {
        super(errorCode.getDescription());
        this.errorCode = errorCode;
    }
}
