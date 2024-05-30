package org.example.view;

import org.example.model.AgeCategory;
import org.example.model.EmploymentCategory;
import org.example.model.GenderCategory;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class FormPanel extends JPanel {
    private FormListener formListener;

    public FormPanel() {
        setLayout(new GridBagLayout());
        JLabel nameLab = new JLabel("Name: ");
        JLabel occupLab = new JLabel("Occupation: ");
        JLabel ageLab = new JLabel("Age: ");
        JLabel empLab = new JLabel("Employment: ");
        JLabel citLab = new JLabel("US citizen: ");
        JLabel taxLab = new JLabel("Tax ID: ");
        taxLab.setEnabled(false);
        JLabel genLab = new JLabel("Gender: ");
        JTextField name = new JTextField(10);
        JTextField occupation = new JTextField(10);

        //Age list
        DefaultListModel<AgeCategory> model = new DefaultListModel<>();
        model.addElement(AgeCategory.MINOR);
        model.addElement(AgeCategory.ADULT);
        model.addElement(AgeCategory.SENIOR);

        JList<AgeCategory> ageList = new JList<>();
        ageList.setModel(model);
        ageList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ageList.setVisibleRowCount(3);
        JScrollPane scrollList = new JScrollPane(ageList);
        Dimension prefSize = name.getPreferredSize();
        scrollList.setPreferredSize(new Dimension(prefSize.width, 60));

        //Employment comboBox
        JComboBox<EmploymentCategory> empComboBox= new JComboBox<>();
        empComboBox.addItem(EmploymentCategory.EMPLOYED);
        empComboBox.addItem(EmploymentCategory.UNEMPLOYED);
        empComboBox.setSelectedIndex(0);

        //CheckBox
        JCheckBox citCheck = new JCheckBox();
        JTextField taxField = new JTextField(10);

        citCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                taxLab.setEnabled(citCheck.isSelected());
                taxField.setEnabled(citCheck.isSelected());
            }
        });

        //Gender radioButtons
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton maleBut = new JRadioButton("male");
        JRadioButton femaleBut = new JRadioButton("female");

        genderGroup.add(maleBut);
        genderGroup.add(femaleBut);

        JButton ok = new JButton("OK");

        /*
        These listeners will send the info from the textFields to the MainFrame
         */
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String personName = name.getText();
                String personOccupation = occupation.getText();
                AgeCategory ageCategory = ageList.getSelectedValue();
                EmploymentCategory employment = (EmploymentCategory) empComboBox.getSelectedItem();
                String taxID = taxField.getText();
                GenderCategory gender;
                if(maleBut.isSelected()){
                    gender = GenderCategory.MALE;
                }else if(femaleBut.isSelected()){
                    gender = GenderCategory.FEMALE;
                }else {
                    gender = null;
                }

                boolean checkUS = citCheck.isSelected();

                if(formListener!=null) {
                    FormEvent e1 = new FormEvent(this, personName, personOccupation, ageCategory, employment, taxID, gender, checkUS);
                    formListener.formInfoEmmited(e1);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        //Constraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(nameLab, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(occupLab, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(ageLab, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(empLab, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(citLab, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        add(taxLab, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        add(genLab, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        add(name, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        add(occupation, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(scrollList, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        add(empComboBox, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor= GridBagConstraints.WEST;
        add(citCheck, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        add(taxField, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        add(maleBut, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        add(femaleBut, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridwidth=2;
        gbc.weighty = 1;
        add(ok, gbc);
    }
    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}
