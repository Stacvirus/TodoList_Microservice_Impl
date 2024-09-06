package com.todo.task_service.controller;

import com.todo.task_service.dto.TaskDto;
import com.todo.task_service.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.XSlf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private static final Logger log = LoggerFactory.getLogger(TaskController.class);
    private final TaskService service;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto){
        log.info(String.format("Creating task: %s", taskDto));
        TaskDto res = service.create(taskDto);
        if(res.getContent() == null){
            return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
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
