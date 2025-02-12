package com.manojll.todo.exception;


/**
 * The type Task not found exception.
 */
public class TaskNotFoundException extends RuntimeException {


    /**
     * Instantiates a new Task not found exception.
     *
     * @param id the id
     */
    public TaskNotFoundException(Integer id) {
        super("task not fount for id : "+ id);
    }
}
