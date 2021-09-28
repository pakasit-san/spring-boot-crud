package com.example.springbootcrud.models.user;

import lombok.Getter;
import lombok.Setter;

/**
 * The request model use for mapping user information request
 *
 * @Getter,@Setter use for generate getter and setter method instead of Boilerplate code
 */
@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
}
