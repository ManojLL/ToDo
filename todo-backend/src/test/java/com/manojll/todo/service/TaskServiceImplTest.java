package com.manojll.todo.service;

import com.manojll.todo.dao.TaskDao;
import com.manojll.todo.dto.TaskDto;
import com.manojll.todo.entity.Task;
import com.manojll.todo.mapper.TaskMapper;
import com.manojll.todo.service.impl.TaskServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TaskServiceImplTest {

    @InjectMocks
    private TaskServiceImpl todoService;

    @Mock
    private TaskMapper taskMapper;

    @Mock
    private TaskDao taskDao;

    @Test
    public void testSaveTask() {
        TaskDto taskDto = new TaskDto();
        Task task = new Task();

        when(taskMapper.toEntity(taskDto)).thenReturn(task);
        when(taskDao.save(task)).thenReturn(task);
        when(taskMapper.toDto(task)).thenReturn(taskDto);

        TaskDto result = todoService.saveTask(taskDto);
        assertEquals(taskDto, result);
    }


}
