package com.manojll.todo.dao;

import com.manojll.todo.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Todo dao.
 */
@Repository
public interface TaskDao extends JpaRepository<Task, Integer> {

    /**
     * Find top 5 by completed order by id desc list.
     *
     * @param completed the completed
     * @return the list
     */
    List<Task> findTop5ByCompletedOrderByIdDesc(boolean completed);
}
