package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RestController // = @Controller +  @ResponseBody
@CrossOrigin
public class UserController {

	@GetMapping("/greet")
//	@ResponseBody
	public String greet() {
		System.out.println("in greet method");
		return "welcome";
	}
	
	// get => 405
	// http://localhost:8080/login
	@PostMapping("/login")
	public String handleLogin() {
		return "login";
	}
	
	
	// 500
	// http://localhost:8080/div?num1=44&num2=0
	@GetMapping("/div")
	public String handleDiv(@RequestParam int num1, @RequestParam int num2) {
		System.out.println(num1/num2);
		return "welcome";
	}

	// any path => 404
	// http://localhost:8080/sayhello
}
