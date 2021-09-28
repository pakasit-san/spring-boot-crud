package com.example.springbootcrud.services;

import com.example.springbootcrud.constants.ResultCode;
import com.example.springbootcrud.entities.UserEntity;
import com.example.springbootcrud.exceptions.CommonException;
import com.example.springbootcrud.models.user.UserRequest;
import com.example.springbootcrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service use for CRUD user information
 */
@Service
public class UserService {

    /**
     * Dependencies injection
     */
    @Autowired
    UserRepository userRepository;

    /**
     * This method use for create user via repository
     *
     * @param userRequest the request object included user information fields that use for create user
     * @return the id of user that created by api
     */
    public Long createUser(UserRequest userRequest) {
        UserEntity userEntity = UserEntity.mappingUserRequest(userRequest);
        userRepository.save(userEntity);
        return userEntity.getId();
    }

    /**
     * This method use for get all user via repository
     *
     * @return the user entries that included user information
     */
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    /**
     * This method use for get user by id via repository
     *
     * @param userId the id of user that use for find user has existed in database or not
     * @return the user information
     * @throws CommonException should be thrown when user has not exist
     */
    public UserEntity getUserById(long userId) throws CommonException {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        return userEntityOptional.orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND, ResultCode.USER_NOT_FOUND));
    }

    /**
     * This method use for update user by id via repository
     *
     * @param userId the id of user that use for find user has existed in database or not
     * @param userRequest the request object included user information fields that use for update user
     * @throws CommonException should be thrown when user has not exist
     */
    public UserEntity updateUser(long userId, UserRequest userRequest) throws CommonException {
        Optional<UserEntity> userEntityOptional = userRepository.findById(userId);
        UserEntity userEntity = userEntityOptional.orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND, ResultCode.USER_NOT_FOUND));
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setMobileNumber(userRequest.getMobileNumber());
        userEntity.setEmail(userRequest.getEmail());
        userRepository.save(userEntity);
        return userEntity;
    }

    /**
     * This method use for delete user by id via repository
     *
     * @param userId the id of user that use for delete user
     * @return the id of user has been deleted
     */
    public Long deleteUser(long userId) {
        userRepository.deleteById(userId);
        return userId;
    }
}
