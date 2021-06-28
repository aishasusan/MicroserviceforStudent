package com.user.service;

import com.user.exception.StudentDepartmentException;
import com.user.exception.StudentIdException;
import com.user.exception.StudentNameException;
import com.user.model.Student;

public interface StudentService {

	public Student getStudentById(Integer id)throws StudentIdException;
	public Student addStudent(Student std)throws StudentIdException,StudentNameException,StudentDepartmentException;
}
