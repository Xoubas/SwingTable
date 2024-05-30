package org.example.model;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
    private List<Person> people;

    public Database() {
        people = new LinkedList<Person>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public List<Person> getPeople() {
        return Collections.unmodifiableList(people);
    }

    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(people);
        oos.close();
        fos.close();
    }

    public void loadFromFile(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            people.clear();
            people.addAll((LinkedList<Person>) ois.readObject());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ois.close();
        fis.close();
    }
}

