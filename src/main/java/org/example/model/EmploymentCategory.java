package org.example.model;

public enum EmploymentCategory {
    UNEMPLOYED(0, "unemployed"),
    EMPLOYED(1, "employed");

    private final int id;
    private final String status;

    EmploymentCategory(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return status;
    }
}
