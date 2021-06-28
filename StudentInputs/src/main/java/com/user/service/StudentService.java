package com.user.service;



import java.util.List;


import com.user.exception.IncompleteDetailsException;
import com.user.exception.StudentDoesntExistsException;
import com.user.exception.StudentExistsException;
import com.user.exception.StudentNotFoundException;
import com.user.model.Student;

public interface StudentService {
	public boolean addStudent(Student std) throws StudentExistsException;
	public boolean deleteStudent(Student std) throws StudentDoesntExistsException,IncompleteDetailsException;
	public boolean updateStudent(Student std) throws StudentDoesntExistsException;
	public List<Student> getallStudent() throws StudentNotFoundException;
}
