package org.example;

import org.example.controller.PasswordsController;
import org.example.model.Password;

import javax.swing.*;
import java.sql.SQLException;

public class AddEditPassword {
    private JTextField urlField;
    private JTextField emailField;
    private JTextField passwordField;
    private JButton saveButton;
    public JPanel addEditPanel;
    private JButton goBackButton;
    private JButton deleteButton;

    private final PasswordsController passwordsController = new PasswordsController();

    public AddEditPassword(Password password) {

        goBackButton.addActionListener(e -> {
            Main.startMainView();
            Main.closeAddEditPassword();
        });

        if(password == null) {
            savePassword();
            return;
        }

        updatePassword(password);

    }

    private void updatePassword(Password password) {
        urlField.setText(password.getUrl());
        emailField.setText(password.getEmail());
        passwordField.setText(password.getPassword());

        saveButton.addActionListener(e -> {
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
                passwordsController.updatePassword(new Password(url, email, passwordText), password.getId());

                Main.closeAddEditPassword();
                Main.startMainView();
            } catch (SQLException exception) {
                exception.printStackTrace();
            }
        });

        deleteButton.addActionListener(e -> {
            try {
                passwordsController.deletePassword(password.getId());
                Main.closeAddEditPassword();
                Main.startMainView();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void savePassword() {
        deleteButton.setVisible(false);

        saveButton.addActionListener(e -> {
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
    }

    private void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(
                addEditPanel, message, title,
                JOptionPane.ERROR_MESSAGE
        );
    }

}
