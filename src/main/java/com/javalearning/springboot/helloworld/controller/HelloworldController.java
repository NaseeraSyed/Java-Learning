package com.javalearning.springboot.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloworldController {

	@GetMapping("/hello")
	public String hello() {
		return "Welcome to Springboot Learning!";
	}
}
