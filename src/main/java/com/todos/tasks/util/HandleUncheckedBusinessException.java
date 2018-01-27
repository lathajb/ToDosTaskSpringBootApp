package com.todos.tasks.util;

/**
 * The HandleUncheckedBusinessException wraps all unchecked standard Java exception.
 * 
 * @author Latha
 */
public class HandleUncheckedBusinessException extends RuntimeException {
    
	private static final long serialVersionUID = -8460356990632230194L;
	
    private final Integer code;
    
    public HandleUncheckedBusinessException(Integer code) {
        super();
        this.code = code;
    }
    public HandleUncheckedBusinessException(String message, Throwable cause, Integer code) {
        super(message, cause);
        this.code = code;
    }
    public HandleUncheckedBusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }
    public HandleUncheckedBusinessException(Throwable cause, Integer code) {
        super(cause);
        this.code = code;
    }
    public Integer getCode() {
        return this.code;
    }
}