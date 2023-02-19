package com.ars.db.contacts.domain;

public class Person {

    private Integer id;
    private String firstname;
    private String lastname;
    private Integer number;
    private String email;
    private String city;

    public Person() {}

    public Person(String firstname, String lastname, Integer number, String email, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.number = number;
        this.email = email;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "\nUser:" + firstname + " " + lastname +
                "\nnumber: " + number +
                "\nemail:" + email +
                "\ncity : " + city;
    }

}
