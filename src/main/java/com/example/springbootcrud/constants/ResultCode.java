package com.example.springbootcrud.constants;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS("SUCCESS", "success"),
    ERROR_USER_NOT_FOUND("ERROR.USER_NOT_FOUND", "user not found");

    private final String code;
    private final String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
