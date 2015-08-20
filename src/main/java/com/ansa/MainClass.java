package com.ansa;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        PersonService personService = new PersonService();

        Person p = new Person();
        p.setName("name");
        personService.save(p);

        List<Person> personList = personService.getAll();

        System.out.println(personList);

        personService.delete(p);

        System.out.println(personService.getAll().size());
    }
}
