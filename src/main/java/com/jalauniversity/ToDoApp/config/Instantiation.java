package com.jalauniversity.ToDoApp.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.jalauniversity.ToDoApp.dto.AuthorDTO;
import com.jalauniversity.ToDoApp.models.Task;
import com.jalauniversity.ToDoApp.models.User;
import com.jalauniversity.ToDoApp.repository.TaskRepository;
import com.jalauniversity.ToDoApp.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepo;
    
    @Autowired
    private TaskRepository taskRepo;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepo.deleteAll();
        taskRepo.deleteAll();

        User igor = new User(null, "Igor Bueno", "igor.bueno@jala.university");
        User bruno = new User(null, "Bruno Pedroso", "bruno.pedroso@jala.university");
        User carlos = new User(null, "Carlos Furtado", "carlos.furtado@jala.university");
        
        userRepo.saveAll(Arrays.asList(igor, bruno, carlos));

        Task task1 = new Task(null,"Projeto Final", "Finalizar o projeto final de Banco de Dados 2", sdf.parse("17/04/2024"), sdf.parse("21/04/2024"), new AuthorDTO(igor));
        Task task2 = new Task(null,"Teste Final de Inglês", "Realizar a avaliação final de inglês", sdf.parse("17/04/2024"), sdf.parse("21/04/2024"), new AuthorDTO(igor));

        taskRepo.saveAll(Arrays.asList(task1, task2));
    
        igor.getTasks().addAll(Arrays.asList(task1, task2));
        userRepo.save(igor);
    }
}
