package org.example.controller;

import org.example.model.Password;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasswordsController {

    Connection connection;
    Statement statement;

    public PasswordsController()  {

        try {
            Class.forName("org.sqlite.JDBC");
            String PASSWORD_DATABASE_PATH = "jdbc:sqlite:src/main/resources/password";
            connection = DriverManager.getConnection(PASSWORD_DATABASE_PATH);


        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void savePassword(Password password) throws SQLException{
        String query = "INSERT INTO passwords (url, email, password) VALUES ( 'google.com', 'qwerty@gmail.com', '13465' )";
        statement = connection.createStatement();
        statement.executeUpdate(query);
    }
    public List<Password> getAllPasswords() throws SQLException {
        List<Password> allPasswords = new ArrayList<>();

        String query = "SELECT (url, email, password) FROM passwords";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String url = resultSet.getString("url");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");

            Password currentPassword = new Password(url, email, password);
        }
        return allPasswords;
    }
}
