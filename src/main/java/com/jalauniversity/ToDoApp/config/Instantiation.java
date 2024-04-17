package com.jalauniversity.ToDoApp.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jalauniversity.ToDoApp.domain.User;
import com.jalauniversity.ToDoApp.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepo;

    @Override
    public void run(String... args) throws Exception {
        userRepo.deleteAll();

        User igor = new User(null, "Igor Bueno", "igor.bueno@jala.university");
        User bruno = new User(null, "Bruno Pedroso", "bruno.pedroso@jala.university");
        User carlos = new User(null, "Carlos Furtado", "carlos.furtado@jala.university");

        userRepo.saveAll(Arrays.asList(igor, bruno, carlos));
    }


}
