package com.jalauniversity.ToDoApp.dto;

import java.io.Serializable;

import com.jalauniversity.ToDoApp.models.User;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    
    public AuthorDTO() {
    }

    public AuthorDTO(User obj) {
        id = obj.getId();
        username = obj.getUsername();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
