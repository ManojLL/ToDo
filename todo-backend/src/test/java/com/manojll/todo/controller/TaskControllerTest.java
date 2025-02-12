package com.manojll.todo.controller;

import com.manojll.todo.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskControllerTest {

    @Mock
    private TaskController taskController;

    @Autowired
    private TaskService taskService;

    @Test
    public void createTaskTest() {

    }

}
