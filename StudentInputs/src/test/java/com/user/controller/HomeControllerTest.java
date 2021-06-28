package com.user.controller;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.google.gson.Gson;
import com.user.model.Student;
import com.user.service.StudentService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HomeControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	private StudentService service;

	@InjectMocks
	private HomeController controller;

	public static Student getStudent() {
		
		Student std = new Student();

		std.setDepartment("mechanical");
		std.setName("Peter");
		
		return std;
	}
	
	
	
	@Test
	public void postStudentTest() throws Exception {

		when(service.addStudent(any())).thenReturn(true);
		mock.perform(MockMvcRequestBuilders.post("/student/update").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getStudent()))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
	
	@Test
	public void putStudentTest() throws Exception {

		when(service.addStudent(any())).thenReturn(true);
		mock.perform(MockMvcRequestBuilders.put("/student/add").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getStudent()))).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(MockMvcResultHandlers.print());

	}
	
	@Test
	public void getStudentTest() throws Exception {

		 List<Student> std = null;
		when(service.getallStudent()).thenReturn(std);
		mock.perform(MockMvcRequestBuilders.get("/student/home").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getStudent()))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
	

	@Test
	public void deleteStudentTest() throws Exception {

		mock.perform(MockMvcRequestBuilders.delete("/").contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(getStudent()))).andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcResultHandlers.print());

	}
	
	
}
