package com.todos.tasks.controller;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.todos.tasks.dto.Task;
import com.todos.tasks.service.ToDoTasksService;
import com.todos.tasks.util.ToDoTasksBusinessException;

/**
 * ToDoTasksController - To manage to do tasks
 * @author Latha
 *
 */

@RestController
@RequestMapping("/tasks")
public class ToDoTasksController {

	Logger logger = LoggerFactory.getLogger(ToDoTasksController.class);
	
	@Autowired
	ToDoTasksService  toDoTaskService;
	
	
	/**
	 * fetchAllTasks - to fetch all tasks
	 * @return List of tasks
	 * @throws ToDoTasksBusinessException 
	 */
	@CrossOrigin
	@RequestMapping(value = "/getTasks", method=RequestMethod.GET)
	public ResponseEntity<List<Task>> fetchAllTasks() throws ToDoTasksBusinessException {
		logger.debug("Inside fetchAllTasks method ");
		List<Task> list = toDoTaskService.fetchAllTasks();
		logger.debug("ToDoTasksController - fetch all tasks completed successfully");
		return new ResponseEntity<List<Task>>(list, HttpStatus.OK);
		
	}
	
	/**
	 * saveTask - used to save a new task
	 * @param task
	 */
	@CrossOrigin
	@RequestMapping(value = "/addTask", method=RequestMethod.POST)
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		logger.debug("Inside saveTask method execution starts ");
		toDoTaskService.saveTask(task);
		logger.debug("Inside saveTask method execution completed ");
		return new ResponseEntity<Task>(task, HttpStatus.OK);
	}
	
	/**
	 * updateTask - To update a specific task
	 * @param task
	 */
	@CrossOrigin
	@RequestMapping(value = "/updateTask", method=RequestMethod.PUT)
	public ResponseEntity updateTask(@RequestBody Task task) {
		logger.debug("Inside updateTask method execution starts ");
		toDoTaskService.updateTask(task);
		logger.debug("Inside updateTask method execution completed ");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	/**
	 * deleteTask - used to deleted a specific task
	 * @param task
	 */
	@CrossOrigin
	@RequestMapping(value = "/deleteTask/{id}", method=RequestMethod.DELETE)
	public ResponseEntity deleteTask(@PathVariable String id) {
		logger.debug("Inside deleteTask method execution starts ");
		toDoTaskService.deleteTask(id);
		logger.debug("Inside deleteTask method execution completed ");
		return new ResponseEntity(HttpStatus.OK);	
	}
	
}
