package org.example.model;

import java.io.Serializable;

public class Person implements Serializable {
    private static int count = 0;
    private int id;
    private String name;
    private String occupation;
    private AgeCategory ageCat;
    private EmploymentCategory empCat;
    private String taxId;
    private boolean usCitizen;
    private GenderCategory gender;

    public Person(String name, String occupation, AgeCategory ageCat, EmploymentCategory empCat, String taxId, boolean usCitizen, GenderCategory gender) {
        id = count++;
        this.name = name;
        this.occupation = occupation;
        this.ageCat = ageCat;
        this.empCat = empCat;
        this.taxId = taxId;
        this.usCitizen = usCitizen;
        this.gender = gender;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public AgeCategory getAgeCat() {
        return ageCat;
    }

    public void setAgeCat(AgeCategory ageCat) {
        this.ageCat = ageCat;
    }

    public EmploymentCategory getEmpCat() {
        return empCat;
    }

    public void setEmpCat(EmploymentCategory empCat) {
        this.empCat = empCat;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public boolean isUsCitizen() {
        return usCitizen;
    }

    public void setUsCitizen(boolean usCitizen) {
        this.usCitizen = usCitizen;
    }

    public GenderCategory getGender() {
        return gender;
    }

    public void setGender(GenderCategory gender) {
        this.gender = gender;
    }
}
