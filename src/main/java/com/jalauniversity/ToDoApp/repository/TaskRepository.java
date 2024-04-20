package com.jalauniversity.ToDoApp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jalauniversity.ToDoApp.models.Task;

@Repository
public interface TaskRepository extends MongoRepository<Task, String>{

    List<Task> findByTitleContainingIgnoreCase(String text);
    List<Task> findByStatus(String status);
}
