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
        List<Person> tempList =  findByFieldName("contact_id", String.valueOf(id));

        return tempList.get(0);
    }

    @Override
    public List<Person> findByName(String name) {
        return findByFieldName("firstname", name);
    }

    @Override
    public List<Person> findByLastname(String lastname) {
        return findByFieldName("lastname", lastname);
    }

    @Override
    public List<Person> findByNumber(String number) {
        return findByFieldName("phone_number", number);
    }

    @Override
    public List<Person> findByEmail(String email) {
        return findByFieldName("email", email);
    }

    @Override
    public List<Person> findByCity(String city) {
        return findByFieldName("city", city);
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
    public void delete(Integer id) {
        try {
            state = con.createStatement();
            state.executeUpdate("DELETE FROM contact_list WHERE contact_id = " + id);
            state.close();
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

    private List<Person> findByFieldName(String fieldName, String fieldValue) {
        List<Person> persons = new ArrayList<>();

        try {
            state = con.createStatement();
            resultSet = state.executeQuery("SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE " + fieldName + " = '" + fieldValue + "'");
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

}

