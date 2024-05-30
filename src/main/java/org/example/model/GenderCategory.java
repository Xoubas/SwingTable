package org.example.model;

public enum GenderCategory {
    MALE(0, "male"),
    FEMALE(1, "female");

    private final int id;
    private final String gender;

    GenderCategory(int id, String gender) {
        this.id = id;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
