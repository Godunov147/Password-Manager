package org.example;

import javax.swing.*;

public class Main {

    static JFrame mainFrame;

    static  JFrame addEditPassword;

    public static void main(String[] args) {
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
    public static void startEditPassword(){
        addEditPassword = new JFrame("");
        addEditPassword.setContentPane(new AddEditPassword().addEditPanel);
        addEditPassword.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addEditPassword.setSize(640, 480);
        addEditPassword.setLocationRelativeTo(null);
        addEditPassword.setVisible(true);
    }
}