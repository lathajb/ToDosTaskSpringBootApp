package com.todos.tasks.service;

import java.util.List;


import com.todos.tasks.dto.Task;
import com.todos.tasks.util.ToDoTasksBusinessException;


/**
 * @author Latha
 * ToDoTasksService
 */
public interface ToDoTasksService {
	
	/**
	 * fetchAllTasks
	 * @return
	 */
	List<Task> fetchAllTasks() throws ToDoTasksBusinessException;
	
	/**
	 * saveTask
	 * @param task
	 */
	void saveTask(Task task);
	
	/**
	 * updateTask
	 * @param task
	 */
	void updateTask(Task task);
	
	/**
	 * deleteTask
	 * @param task
	 */
	void deleteTask(String task);
	
	

}
