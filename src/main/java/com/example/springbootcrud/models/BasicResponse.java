package com.example.springbootcrud.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicResponse<T> {

    private StatusResponse status;
    private T data;

    public BasicResponse(StatusResponse status) {
        this.status = status;
    }

    public BasicResponse(StatusResponse status, T data) {
        this.status = status;
        this.data = data;
    }

    public HttpEntity<?> build(HttpStatus httpStatus) {
        return new ResponseEntity<>(new BasicResponse<>(this.status, this.data), httpStatus);
    }
}
