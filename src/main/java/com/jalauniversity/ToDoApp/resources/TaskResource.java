package com.jalauniversity.ToDoApp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jalauniversity.ToDoApp.domain.Task;
import com.jalauniversity.ToDoApp.repository.util.URL;
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
    
    @RequestMapping(value = "/titleseach", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Task> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }
}
