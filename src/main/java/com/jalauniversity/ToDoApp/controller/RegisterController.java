package com.jalauniversity.ToDoApp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jalauniversity.ToDoApp.dto.UserDTO;
import com.jalauniversity.ToDoApp.models.User;
import com.jalauniversity.ToDoApp.services.UserService;

@RestController
@RequestMapping(value = "/register")
public class RegisterController {
    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody UserDTO objDto) {
        if (service.findByUsername(objDto.getUsername()) != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"status\": \"error\", \"message\": \"usuario já existente\"}");
        }

        User user = service.fromDTO(objDto);
        user = service.insert(user);
        
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
         return ResponseEntity.ok("{\"status\": \"ok\", \"message\": \"" + user.getId() + "\"}");
    }
}
