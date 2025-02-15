package com.manojll.todo.exception.handlers;

import com.manojll.todo.dto.ErrorMessageDto;
import com.manojll.todo.exception.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


/**
 * The type Task not found exception handler.
 */
@ControllerAdvice
public class TaskNotFoundExceptionHandler {


    /**
     * Handle task not found exception response entity.
     *
     * @param exception the exception
     * @return the response entity
     */
    @ExceptionHandler
    public ResponseEntity<ErrorMessageDto> handleTaskNotFoundException(TaskNotFoundException exception) {
        return new ResponseEntity<>(new ErrorMessageDto(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
