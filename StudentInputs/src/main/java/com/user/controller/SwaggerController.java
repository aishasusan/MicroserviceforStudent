package com.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class SwaggerController {
	@Controller
	public class HomeController {
		
		@GetMapping("/")
		public String callSwaggerUI() {
			return "redirect:/swagger-ui.html";
		}
	}
}

