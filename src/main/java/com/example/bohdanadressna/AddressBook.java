package com.example.bohdanadressna;

import javafx.collections.ObservableList;

public interface AddressBook {
    void add(Person person);
    void update(Person person);
    void delete(Person person);
    ObservableList<Person> search(String searchTerm);

}
