package com.manojll.todo.mapper;

import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * The type Task mapper test.
 */
@ExtendWith(MockitoExtension.class)
public class TaskMapperTest {

    @Mock
    private TaskMapper taskMapper;

    /**
     * Test to entity.
     */
    @Test
    public void testToEntity() {
        Task task = new Task();
        TaskDto taskDto = new TaskDto();

        when(taskMapper.toEntity(taskDto)).thenReturn(task);

        Task result = taskMapper.toEntity(taskDto);
        assertNotNull(result);
    }

    /**
     * Test to dto.
     */
    @Test
    public void testToDto() {
        Task task = new Task();
        TaskDto taskDto = new TaskDto();

        when(taskMapper.toDto(task)).thenReturn(taskDto);

        TaskDto result = taskMapper.toDto(task);
        assertNotNull(result);
    }

}
