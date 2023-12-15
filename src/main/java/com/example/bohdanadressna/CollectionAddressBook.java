package com.example.bohdanadressna;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAddressBook implements AddressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    @Override
    public ObservableList<Person> search(String searchTerm) {
        ObservableList<Person> searchResults = FXCollections.observableArrayList();
        for (Person person : personList) {
            if (person.getPip().toLowerCase().contains(searchTerm) ||
                    person.getPhone().toLowerCase().contains(searchTerm)) {
                searchResults.add(person);
            }
        }
        return searchResults;
    }

    public void fillTestData() {
        personList.add(new Person("Yulia", "12231"));
        personList.add(new Person("Oksana", "02365"));
        personList.add(new Person("Petro", "465875"));
    }

    public void print() {
        int number = 0;
        System.out.println();
        for (Person person : personList) {
            number++;
            System.out.println(number + ") ПІП: " + person.getPip() + "; Телефон: " + person.getPhone());
        }
    }
}