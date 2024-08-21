package com.todo.task_service.service.implementation;

import com.todo.task_service.dto.TaskDto;
import com.todo.task_service.entity.Task;
import com.todo.task_service.exception.TaskNotFoundException;
import com.todo.task_service.mapper.TaskMapper;
import com.todo.task_service.repository.TaskRepository;
import com.todo.task_service.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    @Override
    public TaskDto create(TaskDto taskDto) {
        return mapper.toDto(repository.save(mapper.toEntity(taskDto)));
    }

    @Override
    public TaskDto update(TaskDto taskDto, Long id) {
        Task gotTask = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("task with id: "+ id+" not found"));
        return mapper.toDto(repository.save(mapper.updateTask(taskDto, gotTask)));
    }

    @Override
    public TaskDto findOne(Long id) {
        Task gotTask = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("task with id: "+ id+" not found"));

        return mapper.toDto(gotTask);
    }

    @Override
    public List<TaskDto> findAll() {
        return mapper.toTaskDtoList(repository.findAll());
    }

    @Override
    public List<TaskDto> findUserTasks(String id) {
        return mapper.toTaskDtoList(repository.findTaskByUserId(id));
    }

    @Override
    public void delete(Long id) {
        if(id != null){
            repository.deleteById(id);
        }
    }
}
