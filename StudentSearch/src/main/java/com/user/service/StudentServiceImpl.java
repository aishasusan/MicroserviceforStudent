package com.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.reactive.function.client.WebClient;

import com.user.exception.StudentDepartmentException;
import com.user.exception.StudentIdException;
import com.user.exception.StudentNameException;
import com.user.model.Student;

public class StudentServiceImpl implements StudentService {

	private final String GET_STUDENT_BY_ID_URI = "http://localhost:8082/student/search/{productId}";
	private final String POST_ADD_STUDENT = "http://localhost:8082/student/add";
	
	@Autowired
	WebClient.Builder webClientBuilder;

	
	@Override
	public Student getStudentById(Integer id) throws StudentIdException {
		if(id.equals(null))
		{
			throw new StudentIdException("Student ID invalid!!!!!!!!!!");
		}
		return webClientBuilder.build()
				.get()
				.uri(GET_STUDENT_BY_ID_URI, id)
				.retrieve()
				.bodyToMono(Student.class)
				.block();
	}

	@Override
	public Student addStudent(Student std) throws StudentIdException, StudentNameException, StudentDepartmentException {
		if(std.getId().equals(null))
		{
			throw new StudentIdException("Student ID invalid!!!!!!!!!!");
		}
		if(std.getName().equals(null)) {
			throw new StudentNameException("Please enter Student Name");
		}
		if (!((std.getDepartment().length() <= 15) && (std.getDepartment().length() > 0))) {
			throw new StudentDepartmentException("Department Name should be present and maximum lenght be 15");
		}
		return webClientBuilder.build()
				.post()
				.uri(POST_ADD_STUDENT)
				.bodyValue(std)
				.retrieve()
				.bodyToMono(Student.class)
				.block();
	}

	}

