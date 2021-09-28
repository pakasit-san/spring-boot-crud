package com.example.springbootcrud.controllers;

import com.example.springbootcrud.constants.ResultCode;
import com.example.springbootcrud.exceptions.CommonException;
import com.example.springbootcrud.models.BasicResponse;
import com.example.springbootcrud.models.StatusResponse;
import com.example.springbootcrud.models.user.UserRequest;
import com.example.springbootcrud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    private HttpEntity<?> createUser(@RequestBody UserRequest userRequest) {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userService.createUser(userRequest)).build(HttpStatus.CREATED);
    }

    @GetMapping(value = "/users")
    private HttpEntity<?> getAllUser() {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userService.getAllUser()).build(HttpStatus.OK);
    }

    @GetMapping(value = "/users/{userId}")
    private HttpEntity<?> getUserById(@PathVariable(value = "userId") long userId) throws CommonException {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userService.getUserById(userId)).build(HttpStatus.OK);
    }

    //Update user
    //Delete user
}
