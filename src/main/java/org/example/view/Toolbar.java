package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JToolBar {
    //    private StringListener stringListener;
    private ToolbarListener toolbarListener;

    public Toolbar() {
        setLayout(new FlowLayout(FlowLayout.LEFT));

        //Buttons
        JButton save = new JButton(new ImageIcon("src/main/resources/Save16.gif"));
        JButton load = new JButton(new ImageIcon("src/main/resources/Export16.gif"));

        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JButton button = (JButton) e.getSource();
//                if (stringListener != null) {
//                    StringEvent e1 = new StringEvent(this, button.getText());
//                    stringListener.textEmitted(e1);
//                }
//                if (stringListener != null) {
//                    StringEvent e1 = new StringEvent(this, e.getActionCommand());
//                    stringListener.textEmitted(e1);
//                }
            }
        };

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toolbarListener != null) {
                    toolbarListener.opLoadDialog();
                }
            }
        });
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toolbarListener != null) {
                    toolbarListener.opSaveDialog();
                }
            }
        });

        add(load);
        add(save);
    }

    //    public void setStringListener(StringListener listener) {
//        this.stringListener = listener;
//    }
    public void setToolbarListener(ToolbarListener listener) {
        this.toolbarListener = listener;
    }
}
