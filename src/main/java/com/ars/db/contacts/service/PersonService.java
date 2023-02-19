package com.ars.db.contacts.service;

import com.ars.db.contacts.domain.Person;
import com.ars.db.contacts.dto.PersonDto;

import java.util.List;

public interface PersonService {

	void save(PersonDto dto);
	Person getById(Integer id);
	List<Person> getByName(String name);
	List<Person> getByLastname(String lastname);
	List<Person> getByNumber(String number);
	List<Person> getByEmail(String email);
	List<Person> getByCity(String city);
	void update(PersonDto dto);
	void remove(Integer id);
	List<Person> getAll();

} 

