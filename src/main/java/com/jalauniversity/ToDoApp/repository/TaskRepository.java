package com.jalauniversity.ToDoApp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jalauniversity.ToDoApp.domain.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{

}
