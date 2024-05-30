package org.example.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PersonTableModel extends AbstractTableModel {
    private List<Person> personList;
    private final String[] columnNames = {"ID", "Name", "Occupation", "Age Category",
            "Employment Category", "US Citizen", "Tax ID", "Gender"};

    public PersonTableModel() {
    }

    public void setData(List<Person> people) {
        personList = people;
    }

    @Override
    public int getRowCount() {
        return personList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object result = switch (columnIndex) {
            case 0 ->
                    personList.get(rowIndex).getId();
            case 1 ->
                    personList.get(rowIndex).getName();
            case 2 ->
                    personList.get(rowIndex).getOccupation();
            case 3 ->
                    personList.get(rowIndex).getAgeCat();
            case 4 ->
                    personList.get(rowIndex).getEmpCat();
            case 5 ->
                    personList.get(rowIndex).isUsCitizen();
            case 6 ->
                    personList.get(rowIndex).getTaxId();
            case 7 ->
                    personList.get(rowIndex).getGender();
            default ->
                    throw new IndexOutOfBoundsException("La columna: " + columnIndex + " no existe");

        };

        return result;
    }

    @Override
    public String getColumnName(int column) {
        if(column <0 || column >= columnNames.length){
            throw new IndexOutOfBoundsException("La columna: " + column + " no existe");
        }
        return columnNames[column];
    }
}
