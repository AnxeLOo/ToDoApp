package com.jalauniversity.ToDoApp.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jalauniversity.ToDoApp.domain.Task;
import com.jalauniversity.ToDoApp.domain.User;
import com.jalauniversity.ToDoApp.dto.AuthorDTO;
import com.jalauniversity.ToDoApp.dto.TaskDTO;
import com.jalauniversity.ToDoApp.repository.UserRepository;
import com.jalauniversity.ToDoApp.repository.util.URL;
import com.jalauniversity.ToDoApp.services.TaskService;
import com.jalauniversity.ToDoApp.services.UserService;

@RestController
@RequestMapping(value = "/users/{userId}/tasks")
public class TaskResource {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepo;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@PathVariable String userId, @RequestBody TaskDTO objDto) {
        User userObj = userService.findById(userId);
        
        Task taskObj = taskService.fromDTO(objDto, new AuthorDTO(userObj));
        taskObj = taskService.insert(taskObj);
        
        userObj.getTasks().add(taskObj);
        userRepo.save(userObj);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(taskObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable String userId, @PathVariable String taskId, @RequestBody TaskDTO objDto) {
        User userObj = userService.findById(userId);
        
        Task taskObj = taskService.fromDTO(objDto, new AuthorDTO(userObj));
        taskObj.setId(taskId);
        taskObj = taskService.update(taskObj);
        
		return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Task> findById(@PathVariable String id) {
        Task obj = taskService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
    @RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Task> list = taskService.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/statussearch", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> findByStatus(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Task> list = taskService.findByStatus(text);
        return ResponseEntity.ok().body(list);
    }
}
