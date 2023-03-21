package org.example;

import org.example.controller.PasswordsController;
import org.example.model.Password;

import javax.swing.*;
import java.sql.SQLException;

public class AddEditPassword {
    private JTextField urlField;
    private JTextField emailField;

    private final TextCheck textCheck = new TextCheck();
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
            Main.startMainView();
        });

        addButton.addActionListener(e -> {
            String secondField = emailField.getText();
            if (checkField(secondField)) {
                showErrorMessage("Это поле 'E-mail' не можнт быть пустым.", "Ошибка");

            }
        });
        addButton.addActionListener(e -> {
            String thirdField = passwordField.getText();
            if (checkField(thirdField)) {
                showErrorMessage("Это поле 'Пароль' не можнт быть пустым.", "Ошибка");

            }
        });

    }
    private void showErrorMessage(String message, String title) {
        JOptionPane.showMessageDialog(
                addEditPanel, message, title,
                JOptionPane.ERROR_MESSAGE
        );
    }
    private boolean checkField(String firstField){
        return textCheck.isEmptyField(firstField);
    }
}
