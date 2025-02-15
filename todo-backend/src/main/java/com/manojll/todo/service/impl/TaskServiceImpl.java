package com.manojll.todo.service.impl;

import com.manojll.todo.dao.TaskDao;
import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.entity.Task;
import com.manojll.todo.exception.TaskNotFoundException;
import com.manojll.todo.mapper.TaskMapper;
import com.manojll.todo.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Todo service.
 */
@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskDto saveTask(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        task = taskDao.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto updateTask(Integer taskId, TaskDto taskDto) {
        taskDao.findById(taskId).orElseThrow(
                () -> new TaskNotFoundException(taskId)
        );

        Task updatableTask = taskMapper.toEntity(taskDto);
        Task updatedTask = taskDao.save(updatableTask);
        return taskMapper.toDto(updatedTask);
    }

    @Override
    public TaskDto getTask(Integer todoId) {
        Task task = taskDao.findById(todoId).orElseThrow(
                () -> new TaskNotFoundException(todoId)
        );

        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> getAllTask() {
        return taskDao.findAll().stream()
                .map(task -> taskMapper.toDto(task)).toList();
    }

    @Override
    public Integer DeleteTask(Integer taskId) {
        Task task = taskDao.findById(taskId).orElseThrow(
                () -> new TaskNotFoundException(taskId)
        );

        taskDao.deleteById(taskId);
        return taskId;
    }

    @Override
    public List<TaskDto> getLatestFiveTask() {
        return taskDao.findTop5ByCompletedOrderByIdDesc(false).stream()
                .map(task -> taskMapper.toDto(task)).toList();
    }
}
