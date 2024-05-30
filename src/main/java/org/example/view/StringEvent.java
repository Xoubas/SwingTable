package org.example.view;

import java.util.EventObject;

public class StringEvent extends EventObject {
    private String text;

    public StringEvent(Object source) {
        super(source);
    }

    public StringEvent(Object source, String text) {
        super(source);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}