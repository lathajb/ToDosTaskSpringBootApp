package com.tods.tasks.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.todos.tasks.dto.Task;


/**
 * ToDoTasksCustomeRepository
 * @author Latha
 *
 */
public interface ToDoTasksCustomeRepository {
	
	/**
	 * findAllTasks - To fetch all tasks
	 * @return List<Task>
	 */
	List<Task> findAllTasks();
	
	/**
	 * deleteTask - To delete a specific task
	 */
	void deleteTask(String task);
	
	/**
	 * updateTask - To update the task details
	 */
	void updateTask(Task task);
	
	/**
	 * saveTask - To add a new task
	 */
	void saveTask(Task task);
	
	String getNextSequenceNumber(String key);
	

}
