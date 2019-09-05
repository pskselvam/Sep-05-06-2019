package com.synechron.lab02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WordController {

	@Autowired
	private PalindromeService palindromeService;
	
	@PostMapping("/palindrome")
	@ResponseBody
	public String checkForPalindrome(@RequestParam String word) {
		boolean result = palindromeService.check(word);
		String message = word + " is ";
		if(result) {
			message +=  " a ";
		}
		else {
			message +=  " not a ";
		}
		message += "palindrome";
		return  message;
	}
}
