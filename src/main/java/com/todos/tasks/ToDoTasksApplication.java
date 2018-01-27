package com.todos.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ToDoTasksApplication - The ToDoTasksApplication used to manage todo tasks
 * @author Latha
 *
 */
@SpringBootApplication
public class ToDoTasksApplication {
	
	Logger logger = LoggerFactory.getLogger(ToDoTasksApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ToDoTasksApplication.class, args);
		
	}
}
