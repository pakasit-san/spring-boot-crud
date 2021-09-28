package com.example.springbootcrud.models;

import com.example.springbootcrud.constants.ResultCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusResponse {

    private String code;
    private String message;

    public StatusResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
}
