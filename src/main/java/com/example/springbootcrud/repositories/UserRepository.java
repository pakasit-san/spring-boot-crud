package com.example.springbootcrud.repositories;

import com.example.springbootcrud.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The Java Persistence API (JPA) is a specification of Java. It is used to persist data between Java object and relational database.
 * JPA acts as a bridge between object-oriented domain models and relational database systems.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
