package com.example.todo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String assigned) {
        this.description = assigned;
    }
}
