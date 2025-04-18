package com.example.authservice.repository;

import com.example.authservice.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    // You can define custom queries here if needed
    User findByUsername(String username);
}
