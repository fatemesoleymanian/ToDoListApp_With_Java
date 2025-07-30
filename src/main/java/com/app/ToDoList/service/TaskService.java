package com.app.ToDoList.service;

import com.app.ToDoList.model.Task;
import com.app.ToDoList.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompeleted(false);
        repository.save(task);
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = repository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid task id"));
        task.setCompeleted(!task.isCompeleted());
        repository.save(task);
    }
}
