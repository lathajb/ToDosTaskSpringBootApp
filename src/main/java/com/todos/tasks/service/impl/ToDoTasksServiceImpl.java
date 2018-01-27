package com.todos.tasks.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todos.tasks.dto.Task;
import com.todos.tasks.service.ToDoTasksService;
import com.todos.tasks.util.ToDoTasksBusinessException;
import com.tods.tasks.repository.ToDoTasksCustomeRepository;

/**
 * ToDoTasksServiceImpl
 * @author Latha
 *
 */
@Service
public class ToDoTasksServiceImpl implements ToDoTasksService {
	
	Logger logger = LoggerFactory.getLogger(ToDoTasksServiceImpl.class);

	@Autowired
	ToDoTasksCustomeRepository customerRepository;
	
	@Override
	public List<Task> fetchAllTasks()throws ToDoTasksBusinessException{
		logger.debug("Inside fetchAllTasks method ");
		java.util.List<Task> lists = null;
		try{
			lists = customerRepository.findAllTasks();
		}catch(Exception ex){
			logger.error("Exception occured inside fetchAllTasks method ");	
			throw new ToDoTasksBusinessException("Exception Occured while fetching tasks",2001);
		}
		logger.debug("Inside fetchAllTasks method ");
		return lists;
	}
	
	/**
	 * saveTask
	 */
	public void saveTask(Task task){
		customerRepository.saveTask(task);
	}
	
	/**
	 * updateTask
	 */
	public void updateTask(Task task){
		customerRepository.updateTask(task);
	}
	
	/**
	 * deleteTask
	 */
	public void deleteTask(String taskId){
		customerRepository.deleteTask(taskId);
	}
	
	
}
