package com.synechron;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@Value("${message}")
	private String message;
	
	@GetMapping("/hello")
	public String hello() {
		return message;
	}
}
