package com.manojll.todo.controller;

import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@AllArgsConstructor
@Slf4j
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskDto) {
        log.info("POST /api/v1/tasks - Creating a new task with data: {}", taskDto);
        TaskDto saveTask = taskService.saveTask(taskDto);
        log.info("Task created successfully with ID: {}", saveTask.getId());
        return new ResponseEntity<>(saveTask, HttpStatus.CREATED);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable("taskId") Integer taskId, @RequestBody TaskDto taskDto) {
        log.info("PUT /api/v1/tasks - Updating a task with data: {}", taskDto);
        TaskDto updateTodo = taskService.updateTask(taskId, taskDto);
        log.info("Task updated successfully for ID: {}", taskDto.getId());
        return new ResponseEntity<>(updateTodo, HttpStatus.OK);
    }

    @GetMapping("/{taskId}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable("taskId") Integer taskId) {
        log.info("GET /api/v1/task/{ID} - get task with ID: {}", taskId);
        TaskDto taskDto = taskService.getTask(taskId);
        log.info("Task found successfully for ID: {}", taskDto.getId());
        return new ResponseEntity<>(taskDto, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getAllTask() {
        log.info("GET /api/v1/tasks - Get all tasks");
        List<TaskDto> todoList = taskService.getAllTask();
        log.info("Tasks found successfully");
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @GetMapping("/topFive")
    public ResponseEntity<List<TaskDto>> getLatestFiveTask() {
        log.info("GET /api/v1/tasks - Get latest five tasks");
        List<TaskDto> todoList = taskService.getLatestFiveTask();
        log.info("Top five tasks found successfully");
        return new ResponseEntity<>(todoList, HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Integer> deleteTask(@PathVariable("taskId") Integer taskId) {
        log.info("DELETE /api/v1/task/{ID} - deleting task with ID: {}", taskId);
        Integer deletedId = taskService.DeleteTask(taskId);
        log.info("Task deleted successfully");
        return new ResponseEntity<>(deletedId, HttpStatus.OK);
    }

}
