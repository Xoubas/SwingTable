package org.example.view;

import javax.swing.*;
import java.util.EventListener;

public interface ToolbarListener extends EventListener {
    void opSaveDialog();

    void opLoadDialog();
}
