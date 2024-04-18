package com.jalauniversity.ToDoApp.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jalauniversity.ToDoApp.domain.Task;
import com.jalauniversity.ToDoApp.services.TaskService;

@RestController
@RequestMapping(value = "/tasks")
public class TaskResource {

    @Autowired
    private TaskService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> findById(@PathVariable String id) {
        Task obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
