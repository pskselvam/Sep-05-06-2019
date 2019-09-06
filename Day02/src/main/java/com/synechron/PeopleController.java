package com.synechron;

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

@RestController
@RequestMapping("/person")
public class PeopleController {

	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping("/{id}")
	public Person loadPerson(@PathVariable int id) {
		Optional<Person> opt = personRepository.findById(id);
		return opt.orElseGet(() -> new Person());
	}
		
	@PutMapping("/{id}/{age}")
	public String updateAge(@PathVariable int id, @PathVariable int age) {
		Optional<Person> opt = personRepository.findById(id);
		if(opt.isPresent()) {
			Person person = opt.get();
			person.setAge(age);
			personRepository.save(person);
			return "Age updated";
		}
		return "Person with id " + id + " is not found in DB";
	}
	
	@DeleteMapping("/{id}")
	public String deletePerson(@PathVariable int id) {
		Optional<Person> opt = personRepository.findById(id);
		if(opt.isPresent()) {
			Person person = opt.get();
			personRepository.delete(person);
			return "Person with id " + id + " deleted";
		}
		return "Person with id " + id + " is not found in DB";
	}
	
	@GetMapping("/all")
	public Iterable<Person> getAll() {
		return personRepository.findAll();
	}
	
	@PostMapping("/{name}/{age}")
	public String createPerson(@PathVariable String name, 
			@PathVariable int age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		personRepository.save(person);
		return "Success: Person with id " + person.getId() + " is created";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
