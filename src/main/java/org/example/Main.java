package org.example;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Main {

    static JFrame mainFrame;
    static  JFrame addEditPassword;
    static JFrame changePassword;
    static  JFrame deletePassword;

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        startMainView();

    }
    public static void startMainView(){
        mainFrame = new JFrame("Главная");
        mainFrame.setContentPane(new MainView().mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(1280, 720);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
    }
    public static void startEditPassword() throws SQLException {
        addEditPassword = new JFrame("Создать пароль");
        addEditPassword.setContentPane(new AddEditPassword().addEditPanel);
        addEditPassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addEditPassword.setSize(640, 480);
        addEditPassword.setLocationRelativeTo(null);
        addEditPassword.setVisible(true);
    }
    public static void startChangePassword() {
        changePassword = new JFrame("Изменить пароль");
        changePassword.setContentPane(new ChangePassword().changePasswordPanel);
        changePassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        changePassword.setSize(640, 480);
        changePassword.setLocationRelativeTo(null);
        changePassword.setVisible(true);
    }


    public static void closeAddEditPassword() {
        addEditPassword.dispatchEvent(new WindowEvent(addEditPassword, WindowEvent.WINDOW_CLOSING));
    }

    public static void closeMainView() {
        mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));

    }

}