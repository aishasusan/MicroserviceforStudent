package com.user.exception;

public class StudentExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	public  StudentExistsException(String message) {
		super(message);
	}
	
}
