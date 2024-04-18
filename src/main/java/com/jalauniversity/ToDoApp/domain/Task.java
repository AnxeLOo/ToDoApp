package com.jalauniversity.ToDoApp.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jalauniversity.ToDoApp.dto.AuthorDTO;

@Document(collection = "tasks")
public class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String title;
    private String body;
    private String status;
    private Date date;
    private Date endline;
    private AuthorDTO author;

    public Task() {
    }

    public Task(String id, String title, String body, Date date, Date endline, AuthorDTO author) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.status = "incompleto";
        this.date = date;
        this.endline = endline;
        this.author = author;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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
