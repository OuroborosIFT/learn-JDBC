package com.ars.db.contacts.dao;

import com.ars.db.contacts.domain.Person;

import java.util.List;

public interface PersonRepository {

	void create(Person person);
	Person findById(Integer id);
	List<Person> findByName(String name);
	List<Person> findByLastname(String lastname);
	List<Person> findByNumber(String number);
	List<Person> findByEmail(String email);
	List<Person> findByCity(String city);
	void update(Person person);
	void delete(Integer id);
	List<Person> findAll();

}

