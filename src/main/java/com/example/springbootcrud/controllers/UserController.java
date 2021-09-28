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
import org.springframework.web.bind.annotation.*;

/**
 * Restful api for CRUD user information
 *
 * @RequestMapping mapping prefix of web api requests
 */
@RestController
@RequestMapping("/api/v1")
public class UserController {

    /**
     * Dependencies injection
     */
    @Autowired
    UserService userService;

    /**
     * Api use for create user
     *
     * @param userRequest the request object included user information fields that use for create user
     * @return BasicResponse standard of our api include the id of user has been created
     */
    @PostMapping(value = "/users")
    private HttpEntity<?> createUser(@RequestBody UserRequest userRequest) {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userService.createUser(userRequest)).build(HttpStatus.CREATED);
    }

    /**
     * Api use for get all user
     *
     * @return BasicResponse standard of our api include the entries of user information
     */
    @GetMapping(value = "/users")
    private HttpEntity<?> getAllUser() {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userService.getAllUser()).build(HttpStatus.OK);
    }

    /**
     * Api use for get user by id
     *
     * @param userId the id of user that use for find user has existed in database or not
     * @return BasicResponse standard of our api include the user information
     * @throws CommonException should be thrown when user has not exist
     */
    @GetMapping(value = "/users/{userId}")
    private HttpEntity<?> getUserById(@PathVariable(value = "userId") long userId) throws CommonException {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userService.getUserById(userId)).build(HttpStatus.OK);
    }

    /**
     * Api use for update user by id
     *
     * @param userId the id of user that use for find user has existed in database or not
     * @param userRequest the request object included user information fields that use for update user
     * @return BasicResponse standard of our api include the user information
     * @throws CommonException should be thrown when user has not exist
     */
    @PutMapping(value = "/users/{userId}")
    private HttpEntity<?> updateUser(@PathVariable(value = "userId") long userId, @RequestBody UserRequest userRequest) throws CommonException {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userService.updateUser(userId, userRequest)).build(HttpStatus.OK);
    }

    /**
     * This method use for delete user by id
     *
     * @param userId the id of user that use for delete user
     * @return BasicResponse standard of our api include the id of user has been deleted
     */
    @DeleteMapping(value = "/users/{userId}")
    private HttpEntity<?> deleteUser(@PathVariable(value = "userId") long userId) {
        return new BasicResponse<>(new StatusResponse(ResultCode.SUCCESS), userService.deleteUser(userId)).build(HttpStatus.OK);
    }
}
