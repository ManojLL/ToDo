package com.manojll.todo.service.impl;

import com.manojll.todo.dao.TaskDao;
import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.entity.Task;
import com.manojll.todo.exception.TaskNotFoundException;
import com.manojll.todo.mapper.TaskMapper;
import com.manojll.todo.service.TaskService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Todo service.
 */
@Service
@AllArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskMapper taskMapper;

    @Override
    public TaskDto saveTask(TaskDto taskDto) {
        log.info("Saving task: {}", taskDto);
        Task task = taskMapper.toEntity(taskDto);
        task = taskDao.save(task);
        log.info("Saved task successfully with ID : {}", task.getId());
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto updateTask(Integer taskId, TaskDto taskDto) {
        log.info("Updating task with Task ID: {} and TaskDto: {}", taskId, taskDto);
        validateTaskIsExisting(taskId);

        Task updatableTask = taskMapper.toEntity(taskDto);
        Task updatedTask = taskDao.save(updatableTask);
        log.info("Updated task successfully with Task ID: {}", updatedTask.getId());
        return taskMapper.toDto(updatedTask);
    }

    @Override
    public TaskDto getTask(Integer taskId) {
        log.info("getting task with ID: {}", taskId);
        Task task = validateTaskIsExisting(taskId);
        log.info("Task successfully with ID: {}", taskId);
        return taskMapper.toDto(task);
    }

    @Override
    public List<TaskDto> getAllTask() {
        log.info("getting all tasks");
        return taskDao.findAll().stream()
                .map(task -> taskMapper.toDto(task)).toList();
    }

    @Override
    public Integer DeleteTask(Integer taskId) {
        log.info("Deleting task with ID: {}", taskId);
        validateTaskIsExisting(taskId);
        taskDao.deleteById(taskId);
        log.info("Task successfully deleted with ID: {}", taskId);
        return taskId;
    }

    @Override
    public List<TaskDto> getLatestFiveTask() {
        log.info("getting latest five tasks");
        return taskDao.findTop5ByCompletedOrderByIdDesc(false).stream()
                .map(task -> taskMapper.toDto(task)).toList();
    }

    private Task validateTaskIsExisting(Integer taskId) {
        return taskDao.findById(taskId).orElseThrow(
                () -> {
                    log.error("Task not found with ID: {}", taskId);
                    return new TaskNotFoundException(taskId);
                }
        );
    }
}
