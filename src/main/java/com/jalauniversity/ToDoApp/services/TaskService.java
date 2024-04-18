package com.jalauniversity.ToDoApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalauniversity.ToDoApp.domain.Task;
import com.jalauniversity.ToDoApp.dto.AuthorDTO;
import com.jalauniversity.ToDoApp.dto.TaskDTO;
import com.jalauniversity.ToDoApp.repository.TaskRepository;
import com.jalauniversity.ToDoApp.services.exception.ObjectNotFoundException;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public Task insert(Task obj) {
        return repo.insert(obj);
    }

    public Task findById(String id) {
        Optional<Task> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Task> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }

    public List<Task> findByStatus(String status) {
        return repo.findByStatus(status);
    }

    public Task fromDTO(TaskDTO objDto, AuthorDTO userObj) {
        return new Task(objDto. getId(), objDto.getTitle(), objDto.getBody(), objDto.getDate(), objDto.getEndline(), userObj);
    }
}
