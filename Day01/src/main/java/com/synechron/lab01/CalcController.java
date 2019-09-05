package com.synechron.lab01;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController = @Controller + @ResponseBody
@RestController
@RequestMapping("/calc")
public class CalcController {
	
	@Autowired
	private Calculator calculator;
	
	@Autowired
	private List<String> calcOperations;
	
	
	@PostMapping("/diff")
	//@RequestMapping(consumes="application/xml")
	public int diff(@RequestBody CalcOperation calcOperation) {
		return calculator.subtract(calcOperation.getNum1(), calcOperation.getNum2());
	}
	
	
	@GetMapping("/sum/{a}/{b}")
	public CalcOperation sum(@PathVariable int a, @PathVariable int b) {
		int result = calculator.add(a, b);
		CalcOperation calcOperation = new CalcOperation();
		calcOperation.setNum1(a);
		calcOperation.setNum2(b);
		calcOperation.setResult(result);
		return calcOperation;
	}
	
	
	@GetMapping("/ops")
	public List<String> getOperations() {
		return calcOperations;
	}
	
	
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
