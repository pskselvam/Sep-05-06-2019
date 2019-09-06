package com.synechron.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synechron.dao.PersonRepository;
import com.synechron.domain.Person;

@Service
public class PeopleService {
	@Autowired
	private PersonRepository personRepository;

	public List<Person> getAllWithAge( int age) {
		return personRepository.findAllWithAgeGreaterThan(age);
	}

	public List<Person> getByNameAndAge( String name,  int age) {
		return personRepository.findAllByNameAndAge(name, age);
	}

	public Person loadPerson( int id) {
		Optional<Person> opt = personRepository.findById(id);
		return opt.orElseGet(() -> new Person());
	}

	public String updateAge( int id,  int age) {
		Optional<Person> opt = personRepository.findById(id);
		if(opt.isPresent()) {
			Person person = opt.get();
			person.setAge(age);
			personRepository.save(person);
			return "Age updated";
		}
		return "Person with id " + id + " is not found in DB";
	}

	public String deletePerson( int id) {
		Optional<Person> opt = personRepository.findById(id);
		if(opt.isPresent()) {
			Person person = opt.get();
			personRepository.delete(person);
			return "Person with id " + id + " deleted";
		}
		return "Person with id " + id + " is not found in DB";
	}

	public Iterable<Person> getAll() {
		return personRepository.findAll();
	}

	@Transactional(rollbackOn = SynechronException.class)
	public String createPerson( String name, 
			 int age) {
		Person person = new Person();
		person.setName(name);
		person.setAge(age);
		personRepository.save(person);
		return "Success: Person with id " + person.getId() + " is created";
		
	}
}
