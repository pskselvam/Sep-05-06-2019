package com.synechron;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Equivalent of beans.xml or applicationContext.xml
@Configuration
public class AppConfiguration {

	@Bean
	public List<String> calcOperations() {
		return Arrays.asList("add", "subtract", "product", "square");
	}
	
	@Bean
	public List<String> players() {
		return Arrays.asList("Virat", "Dhoni", "product", "square");
	}
}
