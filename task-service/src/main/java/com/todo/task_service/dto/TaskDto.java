package com.todo.task_service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private boolean userStatus;

    private String userId;

    private String title;
    private String content;
    private boolean complete;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Date dueDate;
}
