package com.manojll.todo.service;

import com.manojll.todo.dao.TaskDao;
import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.entity.Task;
import com.manojll.todo.exception.TaskNotFoundException;
import com.manojll.todo.mapper.TaskMapper;
import com.manojll.todo.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {

    @InjectMocks
    private TaskServiceImpl taskService;

    @Mock
    private TaskMapper taskMapper;

    @Mock
    private TaskDao taskDao;

    private Task task;

    private TaskDto taskDto;

    @BeforeEach
    void setUp() {
        task = new Task();
        task.setId(1);
        task.setTitle("title");
        task.setDescription("description");
        task.setCompleted(false);

        taskDto = new TaskDto();
        taskDto.setId(1);
        taskDto.setTitle("title");
        taskDto.setDescription("description");
        taskDto.setCompleted(false);
    }

    @Test
    void saveTaskTestWhenSuccess() {
        when(taskMapper.toEntity(any(TaskDto.class))).thenReturn(task);
        when(taskDao.save(any(Task.class))).thenReturn(task);
        when(taskMapper.toDto(any(Task.class))).thenReturn(taskDto);

        TaskDto savedTask = taskService.saveTask(taskDto);

        assertNotNull(savedTask);
        assertEquals(savedTask.getId(), taskDto.getId());
        assertEquals(savedTask.getTitle(), taskDto.getTitle());
        verify(taskDao, times(1)).save(any(Task.class));
    }

    @Test
    void updateTaskTestWhenSuccess() {
        when(taskDao.findById(anyInt())).thenReturn(Optional.of(task));
        when(taskMapper.toEntity(any(TaskDto.class))).thenReturn(task);
        when(taskDao.save(any(Task.class))).thenReturn(task);
        when(taskMapper.toDto(any(Task.class))).thenReturn(taskDto);

        TaskDto updatedTask = taskService.updateTask(1, taskDto);

        assertNotNull(updatedTask);
        assertEquals(updatedTask.getId(), taskDto.getId());
        assertEquals(updatedTask.getTitle(), taskDto.getTitle());
        verify(taskDao, times(1)).findById(anyInt());
        verify(taskDao, times(1)).save(any(Task.class));
    }

    @Test
    void updateTaskTestWhenTaskIsNotAvailable() {
        when(taskDao.findById(anyInt())).thenReturn(Optional.of(task));
        when(taskDao.findById(anyInt())).thenReturn(Optional.empty());

        TaskNotFoundException exception = assertThrows(TaskNotFoundException.class, () -> {
            taskService.updateTask(3, taskDto);
        });

        assertEquals("task not fount for id : 3", exception.getMessage());
    }

    @Test
    void getTaskTestWhenTaskNotFound() {
        when(taskDao.findById(anyInt())).thenReturn(Optional.empty());

        TaskNotFoundException exception = assertThrows(TaskNotFoundException.class, () -> {
            taskService.getTask(1);
        });

        assertEquals("task not fount for id : 1", exception.getMessage());
    }

    @Test
    void getTaskTestWhenSuccess() {
        when(taskDao.findById(anyInt())).thenReturn(Optional.of(task));
        when(taskMapper.toDto(any(Task.class))).thenReturn(taskDto);

        TaskDto fetchedTask = taskService.getTask(1);

        assertNotNull(fetchedTask);
        assertEquals(fetchedTask.getId(), taskDto.getId());
        assertEquals(fetchedTask.getTitle(), taskDto.getTitle());
        verify(taskDao, times(1)).findById(anyInt());
    }

    @Test
    void deleteTaskTestWhenTaskNotFound() {
        when(taskDao.findById(anyInt())).thenReturn(Optional.empty());

        TaskNotFoundException exception = assertThrows(TaskNotFoundException.class, () -> {
            taskService.DeleteTask(1);
        });

        assertEquals("task not fount for id : 1", exception.getMessage());
    }

    @Test
    void deleteTaskWhenSuccess() {
        when(taskDao.findById(anyInt())).thenReturn(Optional.of(task));

        Integer deletedTaskId = taskService.DeleteTask(1);

        assertEquals(1, deletedTaskId);
        verify(taskDao, times(1)).deleteById(anyInt());
    }

    @Test
    void getLatestFiveTaskTestWhenSuccess() {
        when(taskDao.findTop5ByCompletedOrderByIdDesc(anyBoolean())).thenReturn(Collections.singletonList(task));
        when(taskMapper.toDto(any(Task.class))).thenReturn(taskDto);

        List<TaskDto> tasks = taskService.getLatestFiveTask();

        assertNotNull(tasks);
        assertEquals(1, tasks.size());
        assertEquals(tasks.get(0).getId(), taskDto.getId());
        verify(taskDao, times(1)).findTop5ByCompletedOrderByIdDesc(anyBoolean());
    }

    @Test
    void getAllTasksTestWhenSuccess() {
        when(taskDao.findAll()).thenReturn(Collections.singletonList(task));
        when(taskMapper.toDto(any(Task.class))).thenReturn(taskDto);

        List<TaskDto> allTask = taskService.getAllTask();
        assertEquals(1, allTask.size());
        assertEquals(allTask.get(0).getId(), taskDto.getId());
    }

}
