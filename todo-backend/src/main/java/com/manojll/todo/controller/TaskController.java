package com.manojll.todo.controller;

import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@NoArgsConstructor
@AllArgsConstructor
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        TaskDto saveTask = taskService.saveTask(taskDto);
        return new ResponseEntity<>(saveTask, HttpStatus.CREATED);
    }

    @PutMapping("/{todoId}")
    public ResponseEntity<TaskDto> updateTodo(@PathVariable("todoId") Integer todoId, @RequestBody TaskDto taskDto) {
        TaskDto updateTodo = taskService.updateTask(todoId, taskDto);
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }

    @GetMapping("/{todoId}")
    public ResponseEntity<TaskDto> getTodoById(@PathVariable("todoId") Integer todoId) {
        TaskDto taskDto = taskService.getTask(todoId);
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTodo() {
        List<TaskDto> todoList = taskService.getAllTask();
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @GetMapping("/topFive")
    public ResponseEntity<List<TaskDto>> getLatestFiveTodo() {
        List<TaskDto> todoList = taskService.getLatestFiveTask();
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<Integer> deleteTodo(@PathVariable("todoId") Integer todoId) {
        Integer deletedId = taskService.DeleteTask(todoId);
        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }

}
