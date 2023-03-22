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
                Main.startEditPassword(null);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            Main.closeMainView();
        });

        tablePasswords.getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting() && tablePasswords.getSelectedRow() != -1){
                int row = tablePasswords.getSelectedRow();

                //todo: add id
                Password currentPassword = allPassword.get(row);
                try {
                    Main.startEditPassword(currentPassword);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Main.closeMainView();

            }
        });



    }


}
