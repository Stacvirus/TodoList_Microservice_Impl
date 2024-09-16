package com.stac.history_service.errors;

import com.stac.history_service.errors.exceptions.HistoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(HistoryNotFoundException.class)
    public ResponseEntity<ErrorObject> handleHistoryNotFoundException(final HistoryNotFoundException e) {
        ErrorObject errorObject = ErrorObject.builder()
                .message(e.getMessage())
                .timestamp(new Date())
                .statusCode(HttpStatus.NOT_FOUND.value())
                .build();
        return new ResponseEntity<>(errorObject, HttpStatus.NOT_FOUND);
    }
}
