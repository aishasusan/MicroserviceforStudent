package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.user.exception.StudentDepartmentException;
import com.user.exception.StudentIdException;
import com.user.exception.StudentNameException;
import com.user.model.Student;
import com.user.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("/student")
public class HomeController {
	
	@Autowired
	StudentService service;
	
	@GetMapping("/search/{id}")
	@ApiOperation(value = "Search by Student ID")
	public ResponseEntity<?> getProductById(@PathVariable Integer id) throws StudentIdException {
		Student std = new Student();
		std=service.getStudentById(id);
			if (std.equals(null)){			
				return new ResponseEntity<String>("The Student was not found",HttpStatus.BAD_REQUEST); 
			}
		
		return new ResponseEntity<Student>(std,HttpStatus.OK);
	}
	
	
	@PostMapping("/add")
	@ApiOperation(value = "Add Student")
	public  ResponseEntity<?> addStudent(@RequestBody Student std) throws StudentIdException, StudentNameException, StudentDepartmentException{
		Student std1 = new Student();
			std1 = service.addStudent(std);
			if (std.getName().equals(null))
			{
				return new ResponseEntity<String>("Student was Not Added ",HttpStatus.NO_CONTENT); 
			}
		return new ResponseEntity<Student>(std1,HttpStatus.OK);
	}

}
