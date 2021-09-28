package com.example.springbootcrud.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * The basic response model use for return status and data
 *
 * Example,
 *  status: {
 *      code: "SUCCESS",
 *      message: "success"
 *  },
 *  data: {
 *      "firstName": "bla bla"
 *  }
 *
 * @Getter,@Setter use for generate getter and setter method instead of Boilerplate code
 * @JsonInclude use for exclude any field that have null value when serialise to json response
 */
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
