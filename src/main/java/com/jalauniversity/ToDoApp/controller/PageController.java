package com.jalauniversity.ToDoApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class PageController {

    @GetMapping("/")
    public String login() {
        return "index";
    }
}