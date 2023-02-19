package com.ars.db.contacts.dao;

import com.ars.db.contacts.domain.Person;
import com.ars.db.contacts.connect.Connect;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

public class PersonCRUD implements PersonRepository {

    private Connect connect;
    private final Connection con = Connect.getConnection();
    private Statement state;
    private ResultSet resultSet;

    @Override
    public void create(Person person) {
        try {
            state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            state.executeUpdate("INSERT INTO contact_list (firstname, lastname, phone_number, email, city) " +
                    "VALUES ('" + person.getFirstname() + "', " +
                            "'" + person.getLastname() + "', "
                                + person.getNumber() + ", " +
                            "'" + person.getEmail() + "', " +
                            "'" + person.getCity() + "')");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person findById(Integer id) {
        Person person = new Person();

        try {
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE contact_id = " + id);
            while (resultSet.next()) {
                person.setFirstname(resultSet.getString("firstname"));
                person.setLastname(resultSet.getString("lastname"));
                person.setNumber(resultSet.getInt("phone_number"));
                person.setEmail(resultSet.getString("email"));
                person.setCity(resultSet.getString("city"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return person;
    }

    @Override
    public List<Person> findByName(String name) {
        List<Person> persons = new ArrayList<>();

        try {
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE firstname = '" + name + "'");
            while (resultSet.next()) {
                Person person = new Person();
                person.setFirstname(resultSet.getString("firstname"));
                person.setLastname(resultSet.getString("lastname"));
                person.setNumber(resultSet.getInt("phone_number"));
                person.setEmail(resultSet.getString("email"));
                person.setCity(resultSet.getString("city"));

                persons.add(person);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public List<Person> findByLastname(String lastname) {
        List<Person> persons = new ArrayList<>();

        try {
            state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE lastname = '" + lastname + "'");
            while (resultSet.next()) {
                Person person = new Person();
                person.setFirstname(resultSet.getString("firstname"));
                person.setLastname(resultSet.getString("lastname"));
                person.setNumber(resultSet.getInt("phone_number"));
                person.setEmail(resultSet.getString("email"));
                person.setCity(resultSet.getString("city"));

                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public List<Person> findByNumber(String number) {
        List<Person> persons = new ArrayList<>();

        try {
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE phone_number = " + number);
            while (resultSet.next()) {
                Person person = new Person();
                person.setFirstname(resultSet.getString("firstname"));
                person.setLastname(resultSet.getString("lastname"));
                person.setNumber(resultSet.getInt("phone_number"));
                person.setEmail(resultSet.getString("email"));
                person.setCity(resultSet.getString("city"));

                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public List<Person> findByEmail(String email) {
        List<Person> persons = new ArrayList<>();

        try {
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE email = '" + email + "'");
            while (resultSet.next()) {
                Person person = new Person();
                person.setFirstname(resultSet.getString("firstname"));
                person.setLastname(resultSet.getString("lastname"));
                person.setNumber(resultSet.getInt("phone_number"));
                person.setEmail(resultSet.getString("email"));
                person.setCity(resultSet.getString("city"));

                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public List<Person> findByCity(String city) {
        List<Person> persons = new ArrayList<>();

        try {
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE city = '" + city + "'");
            while (resultSet.next()) {
                Person person = new Person();
                person.setFirstname(resultSet.getString("firstname"));
                person.setLastname(resultSet.getString("lastname"));
                person.setNumber(resultSet.getInt("phone_number"));
                person.setEmail(resultSet.getString("email"));
                person.setCity(resultSet.getString("city"));

                persons.add(person);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return persons;
    }

    @Override
    public void update(Person person) {
        try {
            state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            state.executeUpdate("UPDATE contact_list SET " +
                    "firstname = '" + person.getFirstname() + "', " +
                    "lastname = '" + person.getLastname() + "', " +
                    "phone_number = '" + person.getNumber() + "', " +
                    "email = '" + person.getEmail() + "', " +
                    "city = '" + person.getCity() + "' " +
                    "WHERE contact_id = " + person.getId() + ";");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Person person) {
        try {
            state = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            state.executeUpdate("DELETE FROM contact_list WHERE contact_id = " + person.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();

        try {
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT * FROM contact_list");

            while (resultSet.next()) {
                personList.add(new Person(resultSet.getString("firstname"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("phone_number"),
                        resultSet.getString("email"),
                        resultSet.getString("city")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return personList;
    }

}

