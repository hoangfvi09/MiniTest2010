package service;

import model.Person;
import model.Student;

import java.util.ArrayList;

public class PersonManager implements Manageable<Person> {
    ArrayList<Person> people = new ArrayList<>();

    public ArrayList<Person> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Person> people) {
        this.people = people;
    }

    @Override
    public void add(Person person) {
        this.people.add(person);
    }

    @Override
    public void print() {
        for (Person person : this.people) {
            System.out.println(person);
        }
    }

    @Override
    public Person findById(int id) {
        return null;
    }

    @Override
    public void editById(int id, String name, int age, double average) {

    }

    @Override
    public void removeById(int id) {

    }

    @Override
    public int findIndexById(int id) {
        return 0;
    }

}
