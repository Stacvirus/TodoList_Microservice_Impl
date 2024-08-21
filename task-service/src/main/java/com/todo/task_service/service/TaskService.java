package com.todo.task_service.service;

import com.todo.task_service.dto.TaskDto;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    TaskDto create(TaskDto taskDto);

    TaskDto update(TaskDto taskDto, Long id);

    TaskDto findOne(Long id);

    List<TaskDto> findAll();

    List<TaskDto> findUserTasks(String id);

    void delete(Long id);
}
