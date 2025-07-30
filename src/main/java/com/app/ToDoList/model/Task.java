package com.app.ToDoList.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "todo_tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private boolean compeleted;

}
