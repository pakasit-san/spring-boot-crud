package com.example.springbootcrud.models.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
}
