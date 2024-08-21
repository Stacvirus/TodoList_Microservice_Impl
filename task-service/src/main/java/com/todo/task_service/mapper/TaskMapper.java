package com.todo.task_service.mapper;

import com.todo.task_service.dto.TaskDto;
import com.todo.task_service.entity.Task;
import org.mapstruct.*;

import java.time.ZonedDateTime;
import java.util.List;

@Mapper(componentModel = "spring", imports = {ZonedDateTime.class})
public interface TaskMapper {
    @Mapping(target = "createdAt", defaultExpression = "java(ZonedDateTime.now())")
    Task toEntity(TaskDto taskDto);

    TaskDto toDto(Task task);

    List<TaskDto> toTaskDtoList(List<Task> tasks);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "updatedAt", defaultExpression = "java(ZonedDateTime.now())")
    Task updateTask(TaskDto taskDto, @MappingTarget Task task);
}
