package org.example.view;

import org.example.controller.Controller;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class MainFrame extends JFrame {
    private final Controller controller;
    private JTablePanel tablePanel;

    public MainFrame() {
        super("Ola Mundo!");
        setLayout(new BorderLayout());
        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        jsp.setDividerLocation(300);

        //Components initialization
        controller = new Controller();
        tablePanel = new JTablePanel();
        tablePanel.setData(controller.getPeople());
        Toolbar toolbar = new Toolbar();
        FormPanel formPanel = new FormPanel();

        /*
        Esta parte va a crear una barra de menús donde se podrán realizar diversas acciones,
        incluídas acciones con mnemonics.
         */
        JMenuBar menuBar = new JMenuBar();

        //Menus
        JMenu fileMenu = new JMenu("File");
        JMenu windowMenu = new JMenu("Window");

        //Items
        JMenuItem exportItem = new JMenuItem("Export Data...");
        JMenuItem importItem = new JMenuItem("Import Data...");
        JMenuItem exitItem = new JMenuItem("Exit");
        JMenu showSubmenu = new JMenu("Show");
        JCheckBoxMenuItem showForm = new JCheckBoxMenuItem("Person Form");
        showForm.setState(true);

        fileMenu.add(exportItem);
        fileMenu.add(importItem);
        fileMenu.add(new JSeparator());
        fileMenu.add(exitItem);

        showSubmenu.add(showForm);
        windowMenu.add(showSubmenu);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        //Accelerators and mnemonics
        exportItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        importItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        exitItem.setMnemonic('X');
        windowMenu.setMnemonic('W');
        fileMenu.setMnemonic('F');

        //Set menu icons
        fileMenu.setIcon(new ImageIcon("src/main/resources/burger_877951.png"));

        //Action listeners for menu bar
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cerrar la ventana
            }
        });

        showForm.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                formPanel.setVisible(showForm.getState());
                jsp.setVisible(showForm.getState());
                jsp.setDividerLocation(300);
            }
        });

        //FileChooser
        importItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        exportItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        //Toolbar interface
        toolbar.setToolbarListener(new ToolbarListener() {
            @Override
            public void opSaveDialog() {
                save();
            }

            @Override
            public void opLoadDialog() {
                load();
                tablePanel.refresh();
            }
        });

        formPanel.setFormListener(new FormListener() {
            @Override
            public void formInfoEmmited(FormEvent e) {
                controller.addPerson(e);
                tablePanel.refresh();
            }
        });

        // engadir os compoñentes
        setJMenuBar(menuBar);
        add(toolbar, BorderLayout.PAGE_START);
//        add(textPanel, BorderLayout.CENTER);

        //JSplitPane
        jsp.add(formPanel);
        jsp.add(tablePanel);
        add(jsp, BorderLayout.CENTER);

        setSize(600, 500);
        setMinimumSize(new Dimension(500, 400));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        //Exit dialog
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(MainFrame.this,
                        "Do you really want to exit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });
    }

    private void save() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Person files", "per");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showSaveDialog(MainFrame.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Make sure the file has the correct extension
            if (!file.getAbsolutePath().endsWith(".per")) {
                file = new File(file.getAbsolutePath() + ".per");
            }
            // Add logic to save data to the file
            try {
                controller.saveToFile(file);
            } catch (IOException ex) {
                System.err.println("File not found");
            }
        }
    }

    private void load() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Person files", "per");
        fileChooser.setFileFilter(filter);

        int returnVal = fileChooser.showOpenDialog(MainFrame.this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            // Add logic to load data from the file
            try {
                controller.loadFromFile(file);
            } catch (IOException ex) {
                System.err.println("File not found");
            }
        }
    }
}