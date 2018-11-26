package main;

import gui.Gui;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                new Gui();
            }
        });
    }
}
