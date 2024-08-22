package com.todo.task_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ErrorObject> handleTaskNotFoundException(TaskNotFoundException ex, WebRequest req){
        ErrorObject err = ErrorObject.builder()
                .message(ex.getMessage())
                .timestamp(new Date())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<ErrorObject>(err, HttpStatus.NOT_FOUND);
    }
}
