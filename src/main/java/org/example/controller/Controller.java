package org.example.controller;

import org.example.model.AgeCategory;
import org.example.model.Database;
import org.example.model.EmploymentCategory;
import org.example.view.FormEvent;
import org.example.model.Person;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    private final Database db = new Database();

    public List<Person> getPeople() {
        return db.getPeople();
    }

    public void addPerson(FormEvent ev) {
        Person person = new Person(ev.getName(), ev.getOccupation(), ev.getAgeCategory(), ev.getEmployment(), ev.getTaxID(), ev.isCheckUS(), ev.getGender());
        db.addPerson(person);
    }

    public void saveToFile(File file) throws IOException {
        db.saveToFile(file);
    }

    public void loadFromFile(File file) throws IOException {
        db.loadFromFile(file);
    }
}