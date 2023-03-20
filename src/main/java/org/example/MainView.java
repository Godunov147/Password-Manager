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


    List<Password> allPassword;
    PasswordTableModel passwordTableModel;
    PasswordsController passwordsController = new PasswordsController();
    public MainView(){
        try {
            allPassword = passwordsController.getAllPasswords();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        passwordTableModel = new PasswordTableModel(allPassword);
        tablePasswords.setModel(passwordTableModel);

        addButton.addActionListener(e -> {
            try {
                Main.startEditPassword();
                Main.closeMainView();
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



    }


}
