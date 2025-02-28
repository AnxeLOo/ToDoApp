package com.jalauniversity.ToDoApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jalauniversity.ToDoApp.models.User;


@Repository
public interface UserRepository extends MongoRepository<User, String>{
    User findByUsername(String username);
}
