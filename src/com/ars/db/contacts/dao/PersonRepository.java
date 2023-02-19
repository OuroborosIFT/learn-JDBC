package com.ars.db.contacts.dao;

import com.ars.db.contacts.domain.Person;

import java.util.List;

public interface PersonRepository {

	void create(Person person);
	Person findById(Integer id);
	Person findByName(String name);
	Person findByLastname(String lastname);
	Person findByNumber(String number);
	Person findByEmail(String email);
	Person findByCity(String city);
	void update(Person person);
	void delete(Person person);
	List<Person> findAll();

}

