package org.example.controller;

import org.example.model.Password;

import java.sql.SQLException;
import java.util.List;

public interface IPassword {

    void savePassword(Password password) throws SQLException;


    List<Password> getAllPasswords() throws SQLException;




}
