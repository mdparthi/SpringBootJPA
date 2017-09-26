package com.qht.boot.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qht.boot.jpa.model.Person;
import com.qht.boot.jpa.repository.PersonRepository;


@SpringBootApplication
@RestController
public class SpringBootJpaApplication {
	
	@Autowired
	PersonRepository repository;
	
	@RequestMapping("/person")
	public String addPerson() {
		Person person = new Person("Mike", "Rey", 251.34D);
		repository.save(person);
		
		return "New Record Added";

	}
	
	@RequestMapping("/findOne")
	public Person getPerson() {
		return repository.findOne(1L);
	}
	
	@RequestMapping("/person/{id}")
	public Person getOnePerson(@PathVariable("id") Long id) {
		return repository.findOne(id);
	}
	
	@RequestMapping("/count")
	public String countPerson() {
		return "Count is " + repository.count();
		
	}
	
	@RequestMapping("/persons")
	public List<Person> getPersonList() {
		return (List<Person>) repository.findAll();
	}
	
	@RequestMapping("/person/name/{fName}")
	public List<Person> getPersonByFirstName(@PathVariable("fName") String fName){
		return repository.findByFirstName(fName);
		
	}

	@RequestMapping("/person/update/{id}/name/{name}")
	public Person updatePerson(@PathVariable("id") Long id, @PathVariable("name") String name) {
		Person person = repository.findOne(id);
		person.setFirstName(name);
		repository.save(person);
		return person;
	}
	
	

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}
}
