package com.example.springbootcrud.controllers.advice;

import com.example.springbootcrud.exceptions.CommonException;
import com.example.springbootcrud.models.BasicResponse;
import com.example.springbootcrud.models.StatusResponse;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(CommonException.class)
    public HttpEntity<?> commonException(CommonException exception) {
        return new BasicResponse<>(new StatusResponse(exception.getCode(), exception.getMessage())).build(exception.getHttpStatus());
    }
}
