package com.todo.task_service.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(String msg){super(msg);}
}
