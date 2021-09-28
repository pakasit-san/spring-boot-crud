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

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Long createUser(UserRequest userRequest) {
        UserEntity userEntity = UserEntity.mappingUserRequest(userRequest);
        userRepository.save(userEntity);
        return userEntity.getId();
    }

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(long userId) throws CommonException {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userEntity.orElseThrow(() -> new CommonException(HttpStatus.NOT_FOUND, ResultCode.ERROR_USER_NOT_FOUND));
    }
}
