package com.sbt.jschool;

import java.util.ArrayList;

public class Person {
    private final boolean man;
    private final String name;
    private Person spouse;

    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        boolean result = false; //returned value

        //null check
        if (this == null) {
            // женить/замуж кого?
            return result; //здесь надо бросать Exception?
        }

        if (person == null) {
            // женить/замуж за кого?
            return result; //здесь надо бросать Exception?
        }

        //если пол одинаковый, выйдем
        if (this.man == person.man)
            return result;

        //может они уже муж и жена?
        if ((this.spouse != null) && (person.spouse != null)) {
            if ((this.spouse == person) && (person.spouse == this)) {
                System.out.println(this.name + " and " + person.name + " already married");
                return result; // продолжать не надо
                // теоретически может быть ошибка - один супруг его? а другой нет, но по условиям считаем что их все-равно разводим, если они не супруг друг друга (перекрестные ссылки)
            }
        }

        //надо ли их разводить?
        boolean blnDivorceThis = false;
        boolean blnDivorcePerson = false;

        //Бракоразводные (ый) процесс (ы)
        //начнем с супруга, так как при разводе this потеряем супруга
        if (person.spouse != null)
            blnDivorcePerson = true;

        if (this.spouse != null)
            blnDivorceThis = true;

        if (blnDivorcePerson) { //Можно сделать метод divorsePair, так как код повторяется ниже
            person.spouse.divorce();
            person.divorce();
        }

        if (blnDivorceThis) {
            this.spouse.divorce();
            this.divorce();
        }

        //Пора и женить/замуж
        this.spouse = person;
        person.spouse = this;
        System.out.println(this.name + " and " + person.name + " Just married");

        result = true;
        return result;


    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        boolean result = false;

        if (this.spouse != null) {
            this.spouse = null;
            System.out.println(this.name + " divorced");
            result = true;
        }
        return result;
    }


    public String getName() {
        return name;
    }

    public Person getSpouse() {
        return spouse;
    }

    //Вывод на экран состояния - для тестов
    public static void printPersonsState(ArrayList<Person> persons, String eventName) {
        String nameSpouse;
        String status;
        Person spouse;

        System.out.println(" ------- " + eventName);
        for (Person person : persons) {
            if (person != null) {
                spouse = person.getSpouse();
                if (spouse != null) {
                    nameSpouse = spouse.getName();
                    status = "married with " + nameSpouse;
                } else {
                    nameSpouse = "";
                    status = "divorced";
                }
                System.out.println(person.getName() + " is " + status);
            }
        }
        System.out.println(" --------- ");
    }
}