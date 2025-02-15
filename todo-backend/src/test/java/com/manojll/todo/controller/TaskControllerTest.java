package com.manojll.todo.controller;

import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * The type Task controller test.
 */
@ExtendWith(MockitoExtension.class)
public class TaskControllerTest {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private TaskService taskService;

    /**
     * Create task should return created task.
     */
    @Test
    void createTaskShouldReturnCreatedTask() {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(1);
        taskDto.setTitle("title");
        taskDto.setDescription("description");
        taskDto.setCompleted(false);

        when(taskService.saveTask(any(TaskDto.class))).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = taskController.createTask(taskDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(taskDto, response.getBody());
        verify(taskService, times(1)).saveTask(any(TaskDto.class));
    }

    /**
     * Update todo should return updated task.
     */
    @Test
    void updateTodoShouldReturnUpdatedTask() {
        Integer taskId = 1;

        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskId);
        taskDto.setTitle("updated title");
        taskDto.setDescription("updated description");
        taskDto.setCompleted(false);
        when(taskService.updateTask(anyInt(), any(TaskDto.class))).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = taskController.updateTodo(taskId, taskDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskDto, response.getBody());
        verify(taskService, times(1)).updateTask(anyInt(), any(TaskDto.class));
    }

    /**
     * Update todo should return exception when task not available.
     */
    @Test
    void updateTodoShouldReturnExceptionWhenTaskNotAvailable() {
        Integer taskId = 1;

        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskId);
        taskDto.setTitle("updated title");
        taskDto.setDescription("updated description");
        taskDto.setCompleted(false);
        when(taskService.updateTask(anyInt(), any(TaskDto.class))).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = taskController.updateTodo(taskId, taskDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskDto, response.getBody());
        verify(taskService, times(1)).updateTask(anyInt(), any(TaskDto.class));
    }

    /**
     * Gets todo by id should return task by id.
     */
    @Test
    void getTodoByIdShouldReturnTaskById() {
        Integer taskId = 1;

        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskId);
        taskDto.setTitle("title");
        taskDto.setDescription("description");
        taskDto.setCompleted(false);

        when(taskService.getTask(taskId)).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = taskController.getTodoById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskDto, response.getBody());
        verify(taskService, times(1)).getTask(1);
    }

    /**
     * Gets todo by id should return exception when task not available.
     */
    @Test
    void getTodoByIdShouldReturnExceptionWhenTaskNotAvailable() {
        Integer taskId = 1;

        TaskDto taskDto = new TaskDto();
        taskDto.setId(taskId);
        taskDto.setTitle("title");
        taskDto.setDescription("description");
        taskDto.setCompleted(false);

        when(taskService.getTask(taskId)).thenReturn(taskDto);

        ResponseEntity<TaskDto> response = taskController.getTodoById(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskDto, response.getBody());
        verify(taskService, times(1)).getTask(1);
    }

    /**
     * Gets all todo should return list of tasks.
     */
    @Test
    void getAllTodoShouldReturnListOfTasks() {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(1);
        taskDto.setTitle("title");
        taskDto.setDescription("description");
        taskDto.setCompleted(false);

        TaskDto taskDto2 = new TaskDto();
        taskDto.setId(2);
        taskDto.setTitle("title");
        taskDto.setDescription("description");
        taskDto.setCompleted(false);

        List<TaskDto> taskList = new ArrayList<>();
        taskList.add(taskDto);
        taskList.add(taskDto2);

        when(taskService.getAllTask()).thenReturn(taskList);

        ResponseEntity<List<TaskDto>> response = taskController.getAllTodo();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskList, response.getBody());
        verify(taskService, times(1)).getAllTask();
    }

    /**
     * Gets latest five todo should return latest five tasks.
     */
    @Test
    void getLatestFiveTodoShouldReturnLatestFiveTasks() {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(1);
        taskDto.setTitle("title");
        taskDto.setDescription("description");
        taskDto.setCompleted(false);

        TaskDto taskDto2 = new TaskDto();
        taskDto.setId(2);
        taskDto.setTitle("title");
        taskDto.setDescription("description");
        taskDto.setCompleted(false);

        List<TaskDto> taskList = new ArrayList<>();
        taskList.add(taskDto);
        taskList.add(taskDto2);

        when(taskService.getLatestFiveTask()).thenReturn(taskList);

        ResponseEntity<List<TaskDto>> response = taskController.getLatestFiveTodo();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(taskList, response.getBody());
        verify(taskService, times(1)).getLatestFiveTask();
    }

    /**
     * Delete todo should return deleted id.
     */
    @Test
    void deleteTodoShouldReturnDeletedId() {
        Integer deletedId = 1;
        when(taskService.DeleteTask(1)).thenReturn(deletedId);

        ResponseEntity<Integer> response = taskController.deleteTodo(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(deletedId, response.getBody());
        verify(taskService, times(1)).DeleteTask(1);
    }

}
