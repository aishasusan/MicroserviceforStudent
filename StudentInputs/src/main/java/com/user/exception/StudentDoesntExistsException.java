package com.user.exception;

public class StudentDoesntExistsException extends Exception {
	private static final long serialVersionUID = 1L;
	public  StudentDoesntExistsException(String message) {
		super(message);
	}
	
}
