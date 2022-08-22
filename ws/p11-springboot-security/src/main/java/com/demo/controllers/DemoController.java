package com.demo.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class DemoController {

	@GetMapping("/admin")
	public String onlyForAdmin() {
		System.out.println("only for admin");
		return "welcome admin";
	}
	
	@GetMapping("/manager")
	public String onlyForManager() {
		System.out.println("only for manager");
		return "welcome manager";
	}
	
	@GetMapping("/greet")
	public String greet() {
		System.out.println("in greet method");
		return "welcome user";
	}
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable String name) {
		System.out.println("in greet method");
		return "welcome "+name;
	}
	
}
