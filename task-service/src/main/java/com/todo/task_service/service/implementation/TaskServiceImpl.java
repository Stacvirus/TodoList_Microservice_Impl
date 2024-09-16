package com.todo.task_service.service.implementation;

import com.stac.clients.checkUser.UserExists;
import com.todo.task_service.dto.TaskDto;
import com.todo.task_service.entity.Task;
import com.todo.task_service.exception.TaskNotFoundException;
import com.todo.task_service.mapper.TaskMapper;
import com.todo.task_service.repository.TaskRepository;
import com.todo.task_service.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;
    private final RestTemplate restTemplate;

    private final UserExists userExists;

    @Override
    public TaskDto create(TaskDto taskDto) {
        System.out.println("===============>>>>>>>>>>>>><<in the create task implementation");
        taskDto.setUserStatus(false);
        // todo: check user existence from the user service
        //Boolean userExist = restTemplate.getForObject("http://localhost:3005/user-service/api/users/{userId}", Boolean.class, taskDto.getUserId());

        // todo: user feign client for http requests
        Boolean userExist = userExists.userExists(taskDto.getUserId());
        System.out.println("response from user check: ==========>>>>>: "+userExist);
        if (!userExist) {
            return taskDto.builder()
                    .title(null)
                    .content(null)
                    .dueDate(null)
                    .build();
        }
        TaskDto response = mapper.toDto(repository.save(mapper.toEntity(taskDto)));
        response.setUserStatus(true);
        return response;
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

    // todo: save create and update actions in the history service using a message broker
}
