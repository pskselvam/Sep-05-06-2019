package com.synechron.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.synechron.domain.Person;

@Repository
public interface PersonRepository 
	extends CrudRepository<Person, Integer> {

	//select p from Person p inner join Car c  
	@Query("select p from Person p where p.age > :p1")
	List<Person> findAllWithAgeGreaterThan(@Param("p1") int age);
	
	//findBy methods
	Person findByNameAndAge(String name, int age);
	Person findByIdAndName(int id, String name);
	Person findByAgeAndId(int age, int id);
	Person findByAgeAndName(int age, String name);
	
	//findAllBy methods
	List<Person> findAllByNameAndAge(String name, int age);
	List<Person> findAllByIdAndName(int id, String name);
	List<Person> findAllByAgeAndId(int age, int id);
	List<Person> findAllByAgeAndName(int age, String name);	
	
	
	
	
	
	
	
}
