package org.example;

import org.example.controller.PasswordsController;
import org.example.model.Password;
import org.example.model.PasswordTableModel;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MainView {
    public JPanel mainPanel;
    private JTable tablePasswords;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public MainView(){

        List<Password> allPassword;
        PasswordsController passwordsController = new PasswordsController();

        try {
            allPassword = passwordsController.getAllPasswords();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        PasswordTableModel passwordTableModel = new PasswordTableModel(allPassword);
        tablePasswords.setModel(passwordTableModel);

        addButton.addActionListener(e -> {
            try {
                Main.startEditPassword();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        editButton.addActionListener(e -> {
            Main.startChangePassword();
            try {
                passwordsController.savePassword(null);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        deleteButton.addActionListener(e -> {
            Main.startDeletePassword();
            try {
                passwordsController.savePassword(null);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }
}
