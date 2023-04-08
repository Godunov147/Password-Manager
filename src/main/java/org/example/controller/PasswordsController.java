package org.example.controller;

import org.example.model.Password;

import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class PasswordsController implements IPassword{

    Connection connection;

    Statement statement;

    public PasswordsController() {
        try {
            Class.forName("org.sqlite.JDBC");
            String PERSON_DATABASE_PATH = "jdbc:sqlite:src/main/resources/database/passwords.db";
            connection = DriverManager.getConnection(PERSON_DATABASE_PATH);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void savePassword(Password passwordSave) throws SQLException {
        String url = passwordSave.getUrl();
        String email = passwordSave.getEmail();
        String password = passwordSave.getPassword();

        String query = MessageFormat.format("INSERT INTO passwords (url, email, password) VALUES ( ''{0}'' , ''{1}'' , ''{2}'' )", url, email, password);

        statement = connection.createStatement();
        statement.executeUpdate(query);
    }

    public void deletePassword(int id) throws SQLException {

        String query = "DELETE FROM passwords WHERE id = " + id;

        statement = connection.createStatement();
        statement.execute(query);
    }

    public void updatePassword(Password password, int id) throws SQLException {
        String query = "UPDATE passwords SET url = '"+password.getUrl()+"'," +
                "email = '"+password.getEmail() +"', password = '" + password.getPassword() +"' " +
                "WHERE id = " + id;

        statement = connection.createStatement();
        statement.execute(query);
    }

    @Override
    public List<Password> getAllPasswords() throws SQLException {
        List<Password> allPasswords = new ArrayList<>();

        String query = "SELECT * FROM passwords";
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String url = resultSet.getString("url");
            String email = resultSet.getString("email");
            String password = resultSet.getString("password");

            Password currentPassword = new Password(url, email, password);
            currentPassword.setId(id);

            allPasswords.add(currentPassword);
        }

        return allPasswords;
    }

}
