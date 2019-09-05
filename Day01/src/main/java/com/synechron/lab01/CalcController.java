package com.synechron.lab01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/calc")
public class CalcController {
	
	@Autowired
	private Calculator calculator;
	
	@GetMapping("/add/{a}/{b}")
	public int add(@PathVariable("a") int a, @PathVariable int b) {
		return calculator.add(a, b);
	}

	@PutMapping("/subtract/{a}/{b}")
	public int subtract(@PathVariable int a, @PathVariable int b) {
		return calculator.subtract(a, b);
	}
	
	@PostMapping("/product")
	public int product(@RequestParam("num1") int a, 
			@RequestParam("num2") int b) {
		return calculator.multiply(a, b);
	}
	
	@GetMapping("/square/{a}")
	public int square(@PathVariable int a) {
		return calculator.square(a);
	}
	
	
	
	
	
}
