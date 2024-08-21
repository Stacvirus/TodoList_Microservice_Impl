package com.todo.task_service.controller;

import com.todo.task_service.dto.TaskDto;
import com.todo.task_service.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        return new ResponseEntity<>(service.create(taskDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(service.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<TaskDto>> getUserTasks(@PathVariable String id){
        return ResponseEntity.ok(service.findUserTasks(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id,
                                              @RequestBody TaskDto taskDto){
        return ResponseEntity.ok(service.update(taskDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.notFound().build();
    }
}
