package com.example.springbootcrud.models;

import com.example.springbootcrud.constants.ResultCode;
import lombok.Getter;
import lombok.Setter;

/**
 * The status model use for return status code and message
 *
 * Example,
 *  status: {
 *      code: "SUCCESS",
 *      message: "success"
 *  }
 */
@Getter
@Setter
public class StatusResponse {

    private String code;
    private String message;

    public StatusResponse(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public StatusResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
