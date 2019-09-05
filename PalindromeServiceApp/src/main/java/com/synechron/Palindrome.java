package com.synechron;

import org.springframework.stereotype.Component;

@Component
public class Palindrome {
	
	public boolean check(String word) {
		StringBuilder sb = new StringBuilder(word);
		sb.reverse();
		return sb.toString().equals(word);
	}
	
}
