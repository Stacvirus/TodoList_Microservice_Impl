package com.todo.task_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Task {
    @Id
    @GeneratedValue
    private Long id;

    private String userId;

    private String title;
    private String content;
    private boolean complete;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private Date dueDate;
}
