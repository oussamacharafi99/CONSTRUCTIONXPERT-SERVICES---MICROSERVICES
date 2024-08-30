package org.example.taskservice.controller;

import org.example.taskservice.model.Task;
import org.example.taskservice.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("save")
    public String saveTask(@RequestBody Task task) {
        taskService.save(task);
        return "The Task has been saved";
    }

    @PutMapping("update/{id}")
    public String updateTask(Task task, @PathVariable Integer id) {
        taskService.update(id, task);
        return "The Task has been updated";
    }

    @GetMapping("get+all")
    public List<Task> getAllTasks() {
        return taskService.findAll();
    }

    @GetMapping("get+id/{id}")
    public Task getTaskById(@PathVariable Integer id) {
        return taskService.findById(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteTask(@PathVariable Integer id) {
        taskService.deleteById(id);
        return "The Task has been deleted";
    }
}
