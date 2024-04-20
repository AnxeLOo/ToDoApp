package com.jalauniversity.ToDoApp.dto;

import java.io.Serializable;
import java.util.Date;

public class TaskDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String title;
    private String body;
    private String status;
    private Date date;
    private Date endline;
    private AuthorDTO author;
    
    public TaskDTO() {
    }

    public TaskDTO(String id, String title, String body, String status, Date date, Date endline, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.status = status;
        this.date = date;
        this.endline = endline;
        this.author = author;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getEndline() {
        return endline;
    }

    public void setEndline(Date endline) {
        this.endline = endline;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    
}
