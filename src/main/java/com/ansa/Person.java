package com.ansa;

import javax.persistence.*;

@Entity
@Table
@NamedQuery(name = "Person.getAll", query = "select p from Person p")
public class Person {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
