package com.manojll.todo.dao;

import com.manojll.todo.entity.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * The type Task dao test.
 */
@ExtendWith(SpringExtension.class)
public class TaskDaoTest {


    @Mock
    private TaskDao taskDao;

    /**
     * Find top 5 by completed order by id desc when incomplete.
     */
    @Test
    void findTop5ByCompletedOrderByIdDescWhenIncomplete() {
        Task task1 = new Task(1, "Task 1", "Description 1", false);
        Task task2 = new Task(2, "Task 2", "Description 2", false);
        Task task3 = new Task(3, "Task 3", "Description 3", false);
        Task task4 = new Task(4, "Task 4", "Description 4", false);
        Task task5 = new Task(5, "Task 5", "Description 5", false);
        Task task6 = new Task(5, "Task 5", "Description 6", false);

        List<Task> tasks = List.of(task5, task4, task3, task2, task1, task6);

        when(taskDao.findTop5ByCompletedOrderByIdDesc(false)).thenReturn(tasks);

        List<Task> result = taskDao.findTop5ByCompletedOrderByIdDesc(false);

        assertNotNull(result);
        assertNotEquals(5, result.size());
    }

    /**
     * Find top 5 by completed order by id desc when success.
     */
    @Test
    void findTop5ByCompletedOrderByIdDescWhenSuccess() {
        Task task1 = new Task(1, "Task 1", "Description 1", false);
        Task task2 = new Task(2, "Task 2", "Description 2", false);
        Task task3 = new Task(3, "Task 3", "Description 3", false);
        Task task4 = new Task(4, "Task 4", "Description 4", false);
        Task task5 = new Task(5, "Task 5", "Description 5", false);

        List<Task> tasks = List.of(task5, task4, task3, task2, task1);

        when(taskDao.findTop5ByCompletedOrderByIdDesc(false)).thenReturn(tasks);

        List<Task> result = taskDao.findTop5ByCompletedOrderByIdDesc(false);

        assertEquals(5, result.size());
        assertEquals(result.get(0).getId(), task5.getId());
        assertEquals(result.get(4).getId(), task1.getId());
    }
}
