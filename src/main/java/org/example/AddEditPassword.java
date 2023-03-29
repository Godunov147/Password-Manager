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
    private JButton goBackButton;

    public AddEditPassword(Password password) {
        PasswordsController passwordsController = new PasswordsController();

        goBackButton.addActionListener(e -> {
            Main.startMainView();
            Main.closeAddEditPassword();
        });

        addButton.addActionListener(e -> {
            String url = urlField.getText();
            String email = emailField.getText();
            String passwordText = passwordField.getText();

            if (TextCheck.isEmptyField(url) ||
                    TextCheck.isEmptyField(email) ||
                    TextCheck.isEmptyField(passwordText)) {
                showErrorMessage("Это поле не может быть пустым", "Ошибка");
                return;
            }

            try {
                passwordsController.savePassword(new Password(url, email, passwordText));
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            Main.closeAddEditPassword();
            Main.startMainView();
        });

        if (password == null) {
            return;
        }

        urlField.setText(password.getUrl());
        emailField.setText(password.getEmail());
        passwordField.setText(password.getPassword());



    }

    private void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(
                addEditPanel, message, title,
                JOptionPane.ERROR_MESSAGE
        );
    }

}
