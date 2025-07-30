package com.app.ToDoList.service;

import com.app.ToDoList.model.Task;
import com.app.ToDoList.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceTest {
    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    @Test
    void testCreateTask() {
        taskService.createTask("Test Task");

        Mockito.verify(taskRepository).save(Mockito.argThat(task -> task.getTitle().equals("Test Task")));
    }

    @Test
    void testToggleTask() {
        Task task = new Task();
        task.setId(1L);
        task.setCompeleted(false);

        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        taskService.toggleTask(1L);

        assertTrue(task.isCompeleted());
        Mockito.verify(taskRepository).save(task);
    }

    @Test
    void testDeleteTask() {
        taskService.deleteTask(1L);
        Mockito.verify(taskRepository).deleteById(1L);
    }

    @Test
    void testGetAllTasks() {
        List<Task> tasks = List.of(new Task());
        Mockito.when(taskRepository.findAll()).thenReturn(tasks);

        List<Task> result = taskService.getAllTasks();

        assertEquals(1, result.size());
    }


}