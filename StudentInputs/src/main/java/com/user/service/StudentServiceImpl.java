package com.user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.exception.IncompleteDetailsException;
import com.user.exception.StudentDoesntExistsException;
import com.user.exception.StudentExistsException;
import com.user.exception.StudentNotFoundException;
import com.user.model.Student;

import user.com.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentDao stdRepo;
	
	
	public boolean addStudent(Student std) throws StudentExistsException {
		if(!((stdRepo.findById(std.getId())==null)))
		{
			throw new StudentExistsException("Student Already Exists!!!!!!!!!!");
		}
		stdRepo.save(std);
		return true;
				
	}

	public boolean deleteStudent(Student std) throws StudentDoesntExistsException, IncompleteDetailsException {
		if((std.getDepartment()==null) || (std.getId()==null) ||(std.getName() == null))//if((std.getDepartment().equals(null)) || (std.getId()==null) ||(std.getName() == null))
		{
			throw new IncompleteDetailsException("Please give all the details of Student!!!!!!!!!");
		}
		if(((stdRepo.findById(std.getId())==null)))
		{
			throw new StudentDoesntExistsException("Student Doesnt Exists!!!!!!!!!!");
		}
		stdRepo.delete(std);
		return true;
	}

	public boolean updateStudent(Student std) throws StudentDoesntExistsException{
		if(!(stdRepo.findById(std.getId()).isPresent()))
		{
			throw new StudentDoesntExistsException("Student Doesn't Exists!!!!!!!!!!");
		}
		Student tempStudent = stdRepo.findById(std.getId()).get();
		tempStudent.setName(std.getName());
		tempStudent.setDepartment(std.getDepartment());
		stdRepo.save(tempStudent);
		return true;
	}

	@Override
	public List<Student> getallStudent() throws StudentNotFoundException {

		return stdRepo.findAll();
	}
		
}
