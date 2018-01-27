package com.todos.tasks.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.todos.tasks.dto.Task;
import com.todos.tasks.util.SequenceId;
import com.tods.tasks.repository.ToDoTasksCustomeRepository;


/**
 * ToDoTasksCustomRepositoryImpl
 * @author Latha
 *
 */
@Repository
public class ToDoTasksCustomRepositoryImpl implements ToDoTasksCustomeRepository {

	@Autowired
    MongoTemplate mongoTemplate;
	
	@Autowired
	MongoOperations mongoOperation;
	
	
	/**
	 * findAllTasks - To fetch all tasks
	 * @return List<Task>
	 */
	@Override
	public List<Task> findAllTasks() {
		return mongoTemplate.findAll(Task.class);	 
	}

	/**
	 * deleteTask - To delete a specific task
	 */
	@Override
	public void deleteTask(String id) {
		Task task = new Task();
		task.setId(id);
		mongoTemplate.remove(task);	
		
	}

	/**
	 * updateTask - To update the task details
	 */
	@Override
	public void updateTask(Task task) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(task.getId()));
		
		Update update = new Update();
		update.set("name", task.getName());
		update.set("description", task.getDescription());
		update.set("status", task.getStatus());
		mongoTemplate.updateFirst(query, update, Task.class);
		
		
		/*Task updatedTask = mongoTemplate.findOne(
				Query.query(Criteria.where("_id").is(task.getId())), Task.class);
				mongoTemplate.save(updatedTask, "tasks");*/
	}
	
	
	/**
	 * getNextSequenceNumber - to generate next sequence number
	 */
	@Override
	public String getNextSequenceNumber(String key) {
	Query query = new Query(Criteria.where("_id").is(key));
	Update update = new Update();
	update.inc("seq", 1);
	FindAndModifyOptions options = new FindAndModifyOptions();
	options.returnNew(true);
	SequenceId seqId = mongoOperation.findAndModify(query, update, options, SequenceId.class);
	return seqId.getSeq().toString();	
		
	}

	
	/**
	 * saveTask - To add a new task
	 */
	@Override
	public void saveTask(Task task) {
		task.setId(getNextSequenceNumber("_id"));
		mongoTemplate.save(task);
	}

	

}
