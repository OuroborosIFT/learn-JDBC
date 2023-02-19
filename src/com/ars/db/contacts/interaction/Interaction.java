package com.ars.db.contacts.interaction;

import com.ars.db.contacts.domain.Person;
import com.ars.db.contacts.dto.PersonDto;
import com.ars.db.contacts.service.PersonService;
import com.ars.db.contacts.service.PersonServiceImpl;

import java.util.Scanner;
import java.util.List;

public class Interaction {

	private final Scanner scan;
	private final PersonService service;

	public Interaction() {
		scan = new Scanner(System.in);
		service = new PersonServiceImpl();
	}

	public void session() {
		int i = -1;

		do {
			System.out.println("\nВведите номер необходимого действия");
			System.out.println("\t1 - Создать нового пользователя");
			System.out.println("\t2 - Найти абонента по id");
			System.out.println("\t3 - Найти абонента по имени");
			System.out.println("\t4 - Найти абонента по фамилии");
			System.out.println("\t5 - Найти абонента по номеру телефона");
			System.out.println("\t6 - Найти абонента по электроной почте");
			System.out.println("\t7 - Найти абонента по городу проживания");
			System.out.println("\t8 - Удалить пользователя");
			System.out.println("\t9 - Список всех абонентов");
			System.out.println("\t0 - Выход");
			System.out.print(" -> ");
			i = scan.nextInt();
            scan.nextLine();

			switch (i) {
				case 1 :
					saveInteract();
					break;
				case 2 :
					outId();
					break;
				case 3 :
					outName();
					break;
				case 4 :
					outLastname();
					break;
				case 5 :
					outNumber();
					break;
				case 6 :
					outEmail();
					break;
				case 7 :
					outCity();
					break;
				case 8 :
					removeInteract();
					break;
				case 9 :
					outAll();
					break;
				default :
					System.out.println("Сеанс прерван!");
			}
		} while (i != 0);
	}

	private void saveInteract() {
		System.out.println("\nВведите имя нового абонента : ");
        String name = scan.nextLine();
		System.out.print("\nВведите фамилию нового абонента : ");
		String lastname = scan.nextLine();
		System.out.print("\nВведите номер телефона нового абонента : ");
		String number = scan.nextLine();
		System.out.print("\nВведите электроную почту нового абонента : ");
		String email = scan.nextLine();
		System.out.print("\nВведите город проживания нового абонента : ");
		String city = scan.nextLine();
		PersonDto dto = new PersonDto(name, lastname, number, email, city);
		service.save(dto);
	}

	private void outId() {
		System.out.print("\nВведите id абонента : ");
		Integer id = scan.nextInt();
		System.out.println(service.getById(id));
	}

	private void outName() {
		System.out.print("\nВведите имя абонента : ");
		String name = scan.nextLine();
		System.out.println(service.getByName(name));
	}

	private void outLastname() {
		System.out.print("\nВведите фамилию абонента : ");
		String lastname = scan.nextLine();
		System.out.println(service.getByLastname(lastname));
	}

	private void outNumber() {
		System.out.print("\nВведите номер абонента (без знака '+') : ");
		String number = scan.nextLine();
		System.out.println(service.getByNumber(number));
	}

	private void outEmail() {
		System.out.print("\nВведите электроную почту абонента : ");
		String email = scan.nextLine();
		System.out.println(service.getByEmail(email));
	}

	private void outCity() {
		System.out.print("\nВведите город абонента : ");
		String city = scan.nextLine();
		System.out.println(service.getByCity(city));
	}

	private void updateInteract() {
		System.out.print("\nВведите новое имя абонента : ");
		String name = scan.nextLine();
		System.out.print("\nВведите новую фамилию абонента : ");
		String lastname = scan.nextLine();
		System.out.print("\nВведите новый номер телефона абонента : ");
		String number = scan.nextLine();
		System.out.print("\nВведите новую электроную почту абонента : ");
		String email = scan.nextLine();
		System.out.print("\nВведите новый город проживания абонента : ");
		String city = scan.nextLine();
		PersonDto dto = new PersonDto(name, lastname, number, email, city);
		service.update(dto);
	}

	private void removeInteract() {
		System.out.print("\nВведите id пользователя, которого надо удалить : ");
		Integer id = scan.nextInt();
		Person person = service.getById(id);
		PersonDto dto = new PersonDto(person.getFirstname(),
									person.getLastname(),
									person.getNumber(),
									person.getEmail(),
									person.getCity());
		service.remove(dto);
	}

	private void outAll() {
		List<Person> personList = service.getAll();

		for (Person person : personList) {
			System.out.println(person);
		}
	}

}

