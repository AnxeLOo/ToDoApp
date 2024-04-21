package com.jalauniversity.ToDoApp.controller;

import org.springframework.web.bind.annotation.RestController;

import com.jalauniversity.ToDoApp.dto.UserDTO;
import com.jalauniversity.ToDoApp.models.User;
import com.jalauniversity.ToDoApp.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    @Autowired
    private UserService service;

    @Autowired
    private PasswordEncoder pwEncoder;

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody UserDTO obj) {
        User user = service.findByUsername(obj.getUsername());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"status\": \"error\", \"message\": \"Usuario não existente\"}");
        }

        if (!pwEncoder.matches(obj.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"status\": \"error\", \"message\": \"A senha está incorreta\"}");
        }

        return ResponseEntity.ok("{\"status\": \"ok\", \"message\": \"" + user.getId() + "\"}");
    }
}
