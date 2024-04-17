package com.jalauniversity.ToDoApp.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jalauniversity.ToDoApp.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Fernanda", "maria@jala.university");
        User alex = new User("2", "Alex Silva", "alex@jala.university");
        User pedro = new User("3", "Pedro Cavalcante", "pedro@jala.university");

        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex, pedro));

        return ResponseEntity.ok().body(list);
    }
}
