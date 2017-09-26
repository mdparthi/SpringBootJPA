package com.qht.boot.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qht.boot.jpa.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
	public List<Person> findByFirstName(String firstName);

}
