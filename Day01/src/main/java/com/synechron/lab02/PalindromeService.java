package com.synechron.lab02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PalindromeService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${palindromeservice.baseurl}")
	private String palindromeServiceBaseUrl;
	
	
	public boolean check(String word) {
		String url = palindromeServiceBaseUrl + "/" + word;
		ResponseEntity<Boolean> responseEntity = 
				restTemplate.getForEntity(url, Boolean.class);
		return responseEntity.getBody();
	}
}







