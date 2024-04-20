package com.jalauniversity.ToDoApp.dto;

import java.io.Serializable;

import com.jalauniversity.ToDoApp.models.User;

public class UserDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String password;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        this.id = obj.getId();
        this.username = obj.getUsername();
        this.password = obj.getPassword();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
