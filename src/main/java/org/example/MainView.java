package org.example;

import org.example.model.Password;
import org.example.model.PasswordTableModel;

import javax.swing.*;
import java.util.ArrayList;

public class MainView {
    public JPanel mainPanel;
    private JTable tablePasswords;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public MainView(){

        ArrayList<Password> allPassword = new ArrayList<>();
        allPassword.add(new Password("46", "354" , "5555"));

        PasswordTableModel passwordTableModel = new PasswordTableModel(allPassword);
        tablePasswords.setModel(passwordTableModel);

        addButton.addActionListener(e -> {
            Main.startEditPassword();
        });

    }
}
