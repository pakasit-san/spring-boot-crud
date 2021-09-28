package com.example.springbootcrud.constants;

import lombok.Getter;

@Getter
public enum ResultCode {

    SUCCESS("SUCCESS", "success");

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
