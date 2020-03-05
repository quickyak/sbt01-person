package com.sbt.jschool;

import com.sbt.jschool.Person;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Person manPerson1 = new Person(true, "Alex");
        Person manPerson2 = new Person(true, "Borya");
        Person womanPerson1 = new Person(false, "Anna");
        Person womanPerson2 = new Person(false, "Bella");

        ArrayList<Person> persons = new ArrayList<>(Arrays.asList(
                manPerson1,
                manPerson2,
                womanPerson1,
                womanPerson2
        ));


        Person.printPersonsState(persons, "Init");

        manPerson1.marry(womanPerson1);
        Person.printPersonsState(persons, "manPerson1.marry(womanPerson1)");


        manPerson2.marry(womanPerson2);
        Person.printPersonsState(persons, "manPerson2.marry(womanPerson2)");

        manPerson1.marry(womanPerson2);
        Person.printPersonsState(persons, "manPerson1.marry(womanPerson2)");

        manPerson2.marry(womanPerson1);
        Person.printPersonsState(persons, "manPerson2.marry(womanPerson1)");

        womanPerson2.marry(manPerson1);
        Person.printPersonsState(persons, "womanPerson2.marry(manPerson1)");

        manPerson1.marry(null);
        Person.printPersonsState(persons, "manPerson1.marry(null)");

        manPerson1.marry(manPerson1);
        Person.printPersonsState(persons, "manPerson1.marry(manPerson1)");

        manPerson1.marry(manPerson2);
        Person.printPersonsState(persons, "manPerson1.marry(manPerson2)");


//      Здесь исключение     Exception in thread "main" java.lang.NullPointerException
        // ? как его отловить и надо ли не знаю
//        Person personNull = null;
//        personNull.marry(manPerson1);
//        Person.printPersonsState(persons, "personNull.marry(manPerson1)");
    }


}
