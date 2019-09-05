package com.synechron;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	//curl -XPOST 'http://localhost:8080/bye?name=name'
	@PostMapping("/bye")
	@ResponseBody
	public String bye(@RequestParam("name") String name) {
		return "Bye bye " + name;
	}
	
	@GetMapping("/hi/{name}")
	@ResponseBody
	public String hi(@PathVariable("name") String name) {
		return "Hi " + name;
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "Hello Spring boot";
	}
}
