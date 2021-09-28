package com.example.springbootcrud.entities;

import com.example.springbootcrud.models.user.UserRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * An entity is a lightweight persistence domain object.
 * Typically, an entity represents a table in a relational database, and each entity instance corresponds to a row in that table.
 *
 * @Getter,@Setter use for generate getter and setter method instead of Boilerplate code
 */
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;

    public static UserEntity mappingUserRequest(UserRequest userRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setMobileNumber(userRequest.getMobileNumber());
        userEntity.setEmail(userRequest.getEmail());
        return userEntity;
    }
}
