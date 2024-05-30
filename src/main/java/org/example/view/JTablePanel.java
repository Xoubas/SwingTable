package org.example.view;

import org.example.model.Person;
import org.example.model.PersonTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class JTablePanel extends JPanel {
    private JTable table;
    private PersonTableModel model;

    public JTablePanel() {
        model = new PersonTableModel();
        table = new JTable(model);

        setLayout(new BorderLayout());

        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Person> personList) {
        model.setData(personList);
    }

    public void refresh(){
        model.fireTableDataChanged();
    }
}
