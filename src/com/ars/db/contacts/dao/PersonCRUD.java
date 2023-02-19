package com.ars.db.contacts.dao;

import com.ars.db.contacts.domain.Person;
import com.ars.db.contacts.connect.ConnectDB;
import com.ars.db.contacts.connect.Connect;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.List;
import java.util.ArrayList;

public class PersonCRUD implements PersonRepository {

	private ConnectDB connectDB;
	private Connection con;
	private Statement state;
	private ResultSet resultSet;

	@Override
	public void create(Person person) {
		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("INSERT INTO jc_contact (firstname, lastname, phone_number, email, city) " +
										"VALUES ('" + person.getFirstname() + "', '" + person.getLastname() + "', '" + 
										person.getNumber() + "', '" + person.getEmail() + "', '" + person.getCity() + "');'");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}
	}

	@Override
	public Person findById(Integer id) {
		Person person = new Person();

		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM jc_contact WHERE contact_id = " + id + ";");
			person.setFirstname(resultSet.getString("firstname"));
			person.setLastname(resultSet.getString("lastname"));
			person.setNumber(resultSet.getString("phone_number"));
			person.setEmail(resultSet.getString("email"));
			person.setCity(resultSet.getString("city"));

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}

		return person;
	}

	@Override
	public Person findByName(String name) {
		Person person = new Person();

		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE firstname = " + name + ";");
			person.setFirstname(resultSet.getString("firstname"));
			person.setLastname(resultSet.getString("lastname"));
			person.setNumber(resultSet.getString("phone_number"));
			person.setEmail(resultSet.getString("email"));
			person.setCity(resultSet.getString("city"));

		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}

		return person;
	}

	@Override
	public Person findByLastname(String lastname) {
		Person person = new Person();

		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE last_name = " + lastname + ";");
			person.setFirstname(resultSet.getString("firstname"));
			person.setLastname(resultSet.getString("lastname"));
			person.setNumber(resultSet.getString("phone_number"));
			person.setEmail(resultSet.getString("email"));
			person.setCity(resultSet.getString("city"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}

		return person;
	}

	@Override
	public Person findByNumber(String number) {
		Person person = new Person();

		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE phone_number = " + number + ";");
			person.setFirstname(resultSet.getString("firstname"));
			person.setLastname(resultSet.getString("lastname"));
			person.setNumber(resultSet.getString("phone_number"));
			person.setEmail(resultSet.getString("email"));
			person.setCity(resultSet.getString("city"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}

		return person;
	}

	@Override
	public Person findByEmail(String email) {
		Person person = new Person();

		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE email = " + email + ";");
			person.setFirstname(resultSet.getString("firstname"));
			person.setLastname(resultSet.getString("lastname"));
			person.setNumber(resultSet.getString("phone_number"));
			person.setEmail(resultSet.getString("email"));
			person.setCity(resultSet.getString("city"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}

		return person;
	}

	@Override
	public Person findByCity(String city) {
		Person person = new Person();

		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE city = " + city + ";");
			person.setFirstname(resultSet.getString("firstname"));
			person.setLastname(resultSet.getString("lastname"));
			person.setNumber(resultSet.getString("phone_number"));
			person.setEmail(resultSet.getString("email"));
			person.setCity(resultSet.getString("city"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}

		return person;
	}

	@Override
	public void update(Person person) {
		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("UPDATE contact_list SET " +
										"firstname = '" + person.getFirstname() + "', " +
										"lastname = '" + person.getLastname() + "', " +
										"phone_number = '" + person.getNumber() + "', " +
										"email = '" + person.getEmail() + "', " +
										"city = '" + person.getCity() + "' " +
										"WHERE contact_id = " + person.getId() + ";");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}
	}

	@Override
	public void delete(Person person) {
		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			state.executeUpdate("DELETE FROM contact_list WHERE contact_id = " + person.getId() + ";");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}
	}

	@Override
	public List<Person> findAll() {
		List<Person> personList = new ArrayList<>();

		try {
			connectDB = new Connect();
			con = connectDB.startConnect();
			state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			resultSet = state.executeQuery("SELECT * FROM contact_list;");

			while (resultSet.next()) {
				personList.add(new Person(resultSet.getString("firstname"),
									     resultSet.getString("lastname"),
									     resultSet.getString("phone_number"),
									     resultSet.getString("email"),
									     resultSet.getString("city")));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			connectDB.stopConnect();
		}

		return personList;
	}

}

