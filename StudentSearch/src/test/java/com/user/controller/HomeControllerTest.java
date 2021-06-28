package com.user.controller;


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

	mock.perform(MockMvcRequestBuilders.post("/student/search/2").contentType(MediaType.APPLICATION_JSON)
			.content(new Gson().toJson(getStudent()))).andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print());

}


@Test
public void getStudentTest() throws Exception {

	mock.perform(MockMvcRequestBuilders.get("/student/add").contentType(MediaType.APPLICATION_JSON)
			.content(new Gson().toJson(getStudent()))).andExpect(MockMvcResultMatchers.status().isOk())
			.andDo(MockMvcResultHandlers.print());

}
}
