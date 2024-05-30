package org.example.model;

public enum AgeCategory {
    MINOR(0, "Under 18"),
    ADULT(1, "18 to 65"),
    SENIOR(2, "65 or over");


    private final int id;
    private final String description;

    AgeCategory(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
