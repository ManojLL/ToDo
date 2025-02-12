package com.manojll.todo.service;

import com.manojll.todo.dto.TaskDto;

import java.util.List;

/**
 * The interface Task service.
 */
public interface TaskService {

    /**
     * Save task task dto.
     *
     * @param taskDto the task dto
     * @return the task dto
     */
    public TaskDto saveTask(TaskDto taskDto);

    /**
     * Update task task dto.
     *
     * @param taskId  the task id
     * @param taskDto the task dto
     * @return the task dto
     */
    public TaskDto updateTask(Integer taskId, TaskDto taskDto);

    /**
     * Gets task.
     *
     * @param taskId the task id
     * @return the task
     */
    public TaskDto getTask(Integer taskId);

    /**
     * Gets all task.
     *
     * @return the all task
     */
    public List<TaskDto> getAllTask();

    /**
     * Delete task integer.
     *
     * @param taskId the task id
     * @return the integer
     */
    public Integer DeleteTask(Integer taskId);

    /**
     * Gets latest five task.
     *
     * @return the latest five task
     */
    public List<TaskDto> getLatestFiveTask();
}
