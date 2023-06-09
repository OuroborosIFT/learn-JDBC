package com.ars.db.contacts.service;

import com.ars.db.contacts.domain.Person;
import com.ars.db.contacts.dto.PersonDto;
import com.ars.db.contacts.dao.PersonRepository;
import com.ars.db.contacts.dao.PersonCRUD;

import java.util.List;
import java.util.ArrayList;

public class PersonServiceImpl implements PersonService {

	private final PersonRepository personRepository;

	public PersonServiceImpl() {
		personRepository = new PersonCRUD();
	}

	@Override
	public void save(PersonDto dto) {
		String name = dto.getFirstname();
		String lastname = dto.getLastname();
		Integer number = dto.getNumber();
		String email = dto.getEmail();
		String city = dto.getCity();
		Person person = new Person(name, lastname, number, email, city);
		personRepository.create(person);
	}

	@Override
	public Person getById(Integer id) {
		return personRepository.findById(id);
	}

	@Override
	public List<Person> getByName(String name) {
		return personRepository.findByName(name);
	}

	@Override
	public List<Person> getByLastname(String lastname) {
		return personRepository.findByLastname(lastname);
	}

	@Override
	public List<Person> getByNumber(String number) {
		return personRepository.findByNumber(number);
	}

	@Override
	public List<Person> getByEmail(String email) {
		return personRepository.findByEmail(email);
	}

	@Override
	public List<Person> getByCity(String city) {
		return personRepository.findByCity(city);
	}

	@Override
	public void update(PersonDto dto) {
		String name = dto.getFirstname();
		String lastname = dto.getLastname();
		Integer number = dto.getNumber();
		String email = dto.getEmail();
		String city = dto.getCity();
		Person person = new Person(name, lastname, number, email, city);
		personRepository.update(person);
	}

	@Override
	public void remove(Integer id) {
		personRepository.delete(id);
	}

	@Override
	public List<Person> getAll() {
		return personRepository.findAll();
	}

}

