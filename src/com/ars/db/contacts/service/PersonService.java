package com.ars.db.contacts.service;

import com.ars.db.contacts.domain.Person;
import com.ars.db.contacts.dto.PersonDto;

import java.util.List;

public interface PersonService {

	void save(PersonDto dto);
	Person getById(Integer id);
	Person getByName(String name);
	Person getByLastname(String lastname);
	Person getByNumber(String number);
	Person getByEmail(String email);
	Person getByCity(String city);
	void update(PersonDto dto);
	void remove(PersonDto dto);
	List<Person> getAll();

} 

