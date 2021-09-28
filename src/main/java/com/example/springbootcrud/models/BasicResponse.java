package com.example.springbootcrud.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
public class BasicResponse<T> {

    private StatusResponse status;
    private T data;

    public BasicResponse(StatusResponse status, T data) {
        this.status = status;
        this.data = data;
    }

    public HttpEntity<BasicResponse> build(HttpStatus httpStatus) {
        return new ResponseEntity<>(new BasicResponse<>(this.status, this.data), httpStatus);
    }
}
