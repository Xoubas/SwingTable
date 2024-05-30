package org.example.view;

import java.util.EventListener;

public interface StringListener extends EventListener {
    public void textEmitted(StringEvent e);
}
