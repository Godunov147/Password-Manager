package org.example;

import org.example.controller.PasswordsController;
import org.example.model.Password;

import javax.swing.*;
import java.sql.SQLException;

public class AddEditPassword {
    private JTextField urlField;
    private JTextField emailField;
    private JTextField passwordField;
    private JButton addButton;
    public JPanel addEditPanel;

    public AddEditPassword() {

        PasswordsController passwordsController = new PasswordsController();

        addButton.addActionListener(e -> {

            String url = urlField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();

            try {
                passwordsController.savePassword(new Password(url, email, password));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            Main.closeAddEditPassword();
        });


    }
}
