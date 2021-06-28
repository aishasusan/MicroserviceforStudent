package com.user.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.exception.StudentNotFoundException;
import com.user.model.Student;
import com.user.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
@RequestMapping("/student")
public class HomeController {

	@Autowired
	StudentService stdService;

	@Autowired
	public HomeController(StudentService stdService) {
		this.stdService = stdService;
	}
	
	@GetMapping("/home")
	@ApiOperation(value = "welcome user")
	public String getMessage() {
		return "Spring Boot Rest for Student OPerations";
	}
	
	
	
	
@PutMapping("/add")
@ApiOperation("value = add student")
public ResponseEntity<String> addStudent(@RequestBody Student std) throws Exception{
	if(stdService.addStudent(std)) {
		if(!stdService.addStudent(std))
		{
			throw new Exception();
		}
		return new ResponseEntity<String>("Student is Added", HttpStatus.CREATED);
	}
	return new ResponseEntity<String>("Student is Added", HttpStatus.CREATED);}

	
	@DeleteMapping("/delete")
	@ApiOperation(value = "Delete Student")
	public ResponseEntity<String> deleteGif(@RequestBody Student std) throws Exception
	{
			if(!stdService.deleteStudent(std))
			{
				throw new Exception();
			}
			return new ResponseEntity<String>("Student is Deleted",HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Student>> getAllStudent() throws StudentNotFoundException {

		return new ResponseEntity<List<Student>>(stdService.getallStudent(), HttpStatus.OK);

	}
	
	@PostMapping("/update")
	@ApiOperation(value = "Update Student")
	public ResponseEntity<String> updateStudent(@RequestBody Student std) throws Exception
	{
			if(!stdService.updateStudent(std))
			{
				throw new Exception();
			}
			return new ResponseEntity<String>("Student is Updated",HttpStatus.OK);
}



}

