package com.jwelifyhub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jwelifyhub.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User>findUserByEmail(String email);  //custom method which return user on the basis of id
    
}

// Optional - is a container obj which basically handle the risk of NullPointerExceptions

// Using Optional in this context allows the caller of the method to handle both cases (user found and user not found) 