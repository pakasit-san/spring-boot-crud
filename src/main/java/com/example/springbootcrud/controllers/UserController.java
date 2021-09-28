package com.example.springbootcrud.controllers;

import com.example.springbootcrud.constants.ResultCode;
import com.example.springbootcrud.models.BasicResponse;
import com.example.springbootcrud.models.StatusResponse;
import com.example.springbootcrud.models.user.UserRequest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private HttpEntity<?> createUser(@RequestBody UserRequest userRequest) {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userRequest).build(HttpStatus.CREATED);
    }


    //Get user
    //Get all user
    //Get user pagination
}
