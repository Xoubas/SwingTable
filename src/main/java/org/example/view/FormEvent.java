package org.example.view;

import org.example.model.AgeCategory;
import org.example.model.EmploymentCategory;
import org.example.model.GenderCategory;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String name;
    private String occupation;
    private AgeCategory ageCategory;
    private EmploymentCategory employment;
    private String taxID;
    private GenderCategory gender;
    private boolean checkUS;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String name, String occupation, AgeCategory ageCategory, EmploymentCategory employment, String taxID, GenderCategory gender, boolean checkUS) {
        super(source);
        this.name = name;
        this.occupation = occupation;
        this.ageCategory = ageCategory;
        this.employment = employment;
        this.taxID = taxID;
        this.gender = gender;
        this.checkUS = checkUS;
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

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public EmploymentCategory getEmployment() {
        return employment;
    }

    public void setEmployment(EmploymentCategory employment) {
        this.employment = employment;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public GenderCategory getGender() {
        return gender;
    }

    public void setGender(GenderCategory gender) {
        this.gender = gender;
    }

    public boolean isCheckUS() {
        return checkUS;
    }

    public void setCheckUS(boolean checkUS) {
        this.checkUS = checkUS;
    }
}

