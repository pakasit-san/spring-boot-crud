package com.example.springbootcrud.exceptions;

import com.example.springbootcrud.constants.ResultCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * The common exception use for service throws a standard exception with error code and message
 *
 * @Getter use for generate getter method instead of Boilerplate code
 */
@Getter
public class CommonException extends Exception {

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    public CommonException(HttpStatus httpStatus, ResultCode resultCode) {
        this.httpStatus = httpStatus;
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }
}
