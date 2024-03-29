package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

	@Autowired
	private Palindrome palindrome;
	
	@GetMapping("/ispalindrome/{word}")
	public boolean check(@PathVariable String word) {
		return palindrome.check(word); 
	}
}
