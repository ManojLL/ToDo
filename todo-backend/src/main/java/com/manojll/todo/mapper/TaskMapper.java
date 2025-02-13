package com.manojll.todo.mapper;

import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.entity.Task;
import org.springframework.stereotype.Component;

/**
 * The type Todo mapper.
 */
@Component
public class TaskMapper implements Mapper<Task, TaskDto> {

    @Override
    public Task toEntity(TaskDto taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setCompleted(taskDto.isCompleted());
        return task;
    }

    @Override
    public TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setTitle(task.getTitle());
        taskDto.setDescription(task.getDescription());
        taskDto.setCompleted(task.isCompleted());
        return taskDto;
    }
}
