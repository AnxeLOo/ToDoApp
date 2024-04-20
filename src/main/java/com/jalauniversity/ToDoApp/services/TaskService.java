package com.jalauniversity.ToDoApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jalauniversity.ToDoApp.dto.AuthorDTO;
import com.jalauniversity.ToDoApp.dto.TaskDTO;
import com.jalauniversity.ToDoApp.models.Task;
import com.jalauniversity.ToDoApp.repository.TaskRepository;
import com.jalauniversity.ToDoApp.services.exception.ObjectNotFoundException;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public Task insert(Task obj) {
        return repo.insert(obj);
    }

    public Task update(Task obj) {
        Task newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Task newObj, Task obj) {
        newObj.setTitle(obj.getTitle());
        newObj.setBody(obj.getBody());
        newObj.setStatus(obj.getStatus());
        newObj.setEndline(obj.getEndline());
        newObj.setAuthor(obj.getAuthor());
    }

    public Task findById(String id) {
        Optional<Task> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }

    public List<Task> findByTitle(String text) {
        return repo.findByTitleContainingIgnoreCase(text);
    }

    public List<Task> findByStatus(String status) {
        return repo.findByStatus(status);
    }

    public Task fromDTO(TaskDTO objDto, AuthorDTO userObj) {
        return new Task(objDto. getId(), objDto.getTitle(), objDto.getBody(), objDto.getStatus(), objDto.getEndline(), userObj);
    }
}
