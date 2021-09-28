package com.example.springbootcrud.constants;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS("SUCCESS", "success"),
    USER_NOT_FOUND("ERROR.USER_NOT_FOUND", "user not found"),
    INTERNAL_SERVER_ERROR("ERROR.INTERNAL_SERVER_ERROR", "internal server error");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
