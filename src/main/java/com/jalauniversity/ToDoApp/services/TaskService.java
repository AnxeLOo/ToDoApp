package com.jalauniversity.ToDoApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalauniversity.ToDoApp.domain.Task;
import com.jalauniversity.ToDoApp.repository.TaskRepository;
import com.jalauniversity.ToDoApp.services.exception.ObjectNotFoundException;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public Task findById(String id) {
        Optional<Task> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Task> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }
}
