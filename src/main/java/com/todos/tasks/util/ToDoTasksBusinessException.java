package com.todos.tasks.util;


public class ToDoTasksBusinessException extends Exception {
	
	    private static final long serialVersionUID = 7718828512143293558L;
	    
	    private final Integer code;
	    
	    public ToDoTasksBusinessException(Integer code) {
	        super();
	        this.code = code;
	    }
	    public ToDoTasksBusinessException(String message, Throwable cause, Integer code) {
	        super(message, cause);
	        this.code = code;
	    }
	    public ToDoTasksBusinessException(String message, Integer code) {
	        super(message);
	        this.code = code;
	    }
	    public ToDoTasksBusinessException(Throwable cause, Integer code) {
	        super(cause);
	        this.code = code;
	    }
	    public Integer getCode() {
	        return this.code;
	    }
	
}
