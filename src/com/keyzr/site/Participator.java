package com.keyzr.site;

import java.util.Map;

public class Participator {
    private String firstName;
    private String surname;
    private int age;
    private Map<String,Integer> answers; // possible variations: <"question1-2">,<0-2>


    public Participator(String firstName, String surname, int age, Map<String, Integer> answers) {
        this.firstName = firstName;
        this.surname = surname;
        this.age = age;
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participator that = (Participator) o;

        if (age != that.age) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        return answers != null ? answers.equals(that.answers) : that.answers == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (answers != null ? answers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Participator{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", answers=" + answers +
                '}';
    }
}
