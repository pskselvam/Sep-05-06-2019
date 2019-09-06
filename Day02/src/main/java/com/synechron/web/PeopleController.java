package com.synechron.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.synechron.domain.Person;
import com.synechron.service.PeopleService;

@RestController
@RequestMapping("/person")
public class PeopleController {

	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("all/greaterthan/{age}")
	public List<Person> getAllWithAge(@PathVariable int age) {
		return peopleService.getAllWithAge(age);
	}
	
	@GetMapping("/{name}/{age}")
	public List<Person> getByNameAndAge(@PathVariable String name, @PathVariable int age) {
		return peopleService.getByNameAndAge(name, age);
	}
	
	@GetMapping("/{id}")
	public Person loadPerson(@PathVariable int id) {
		return peopleService.loadPerson(id);
	}
		
	@PutMapping("/{id}/{age}")
	public String updateAge(@PathVariable int id, @PathVariable int age) {
		return peopleService.updateAge(id, age);
	}
	
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable int id) {
		return peopleService.deletePerson(id);
	}
	
	@GetMapping("/all")
	public Iterable<Person> getAll() {
		System.out.println("******PeopleService: " + peopleService.getClass().getName());
		return peopleService.getAll();
	}
	
	@PostMapping("/{name}/{age}")
	public String createPerson(@PathVariable String name, 
			@PathVariable int age) {
		return peopleService.createPerson(name, age);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
