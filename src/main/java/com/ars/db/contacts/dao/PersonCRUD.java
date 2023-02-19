package com.ars.db.contacts.dao;

import com.ars.db.contacts.domain.Person;
import com.ars.db.contacts.connect.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

public class PersonCRUD implements PersonRepository {

    private Connect connect;
    private final Connection con = Connect.getConnection();
    private PreparedStatement state;
    private ResultSet resultSet;

    @Override
    public void create(Person person) {
        try {
            String sql = "INSERT INTO contact_list (firstname, lastname, phone_number, email, city) VALUES (?, ?, ?, ?, ?)";
            state = con.prepareStatement(sql);
            state.setString(1, person.getFirstname());
            state.setString(2, person.getLastname());
            state.setInt(3, person.getNumber());
            state.setString(4, person.getEmail());
            state.setString(5, person.getCity());
            state.executeUpdate();
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
            String sql = "UPDATE contact_list SET firstname = ?, lastname = ?, phone_number = ?, email = ?, city = ? WHERE contact_id = ?";
            state = con.prepareStatement(sql);
            state.setString(1, person.getFirstname());
            state.setString(2, person.getLastname());
            state.setInt(3, person.getNumber());
            state.setString(4, person.getEmail());
            state.setString(5, person.getCity());
            state.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM contact_list WHERE contact_id = ?";
            state = con.prepareStatement(sql);
            state.setInt(1, id);
            state.executeUpdate();
            state.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findAll() {
        List<Person> personList = new ArrayList<>();

        try {
            String sql = "SELECT * FROM contact_list";
            state = con.prepareStatement(sql);
            resultSet = state.executeQuery();

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
            String sql = "SELECT firstname, lastname, phone_number, email, city FROM contact_list WHERE " + fieldName + " = ?";
            state = con.prepareStatement(sql);
            state.setString(1, fieldValue);
            resultSet = state.executeQuery();
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
