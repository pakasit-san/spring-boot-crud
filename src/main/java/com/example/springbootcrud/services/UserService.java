package com.example.springbootcrud.services;

import com.example.springbootcrud.entities.UserEntity;
import com.example.springbootcrud.models.user.UserRequest;
import com.example.springbootcrud.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public UserEntity getUserById(long userId) throws Exception {
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        return userEntity.orElseThrow(()-> new Exception("error"));
    }
}
