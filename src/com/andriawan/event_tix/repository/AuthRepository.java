/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andriawan.event_tix.repository;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.andriawan.event_tix.data.DBConn;
import com.andriawan.event_tix.utils.PasswordUtil;

/**
 *
 * @author naufalfawwaz
 */
public class AuthRepository extends DBConn {
    
    public Boolean register(String nama, String email, String password) {

        try {
            stmt = (PreparedStatement) connection.prepareStatement("INSERT INTO users (name, email, password, password_salt) VALUE (?, ?, ?, ?)");
            ((PreparedStatement) stmt).setString(1, nama);
            ((PreparedStatement) stmt).setString(2, email);

            String passwordSalt = PasswordUtil.getSaltValue(30);
            String generatedPassword = PasswordUtil.generateSecurePassword(password, passwordSalt);
            ((PreparedStatement) stmt).setString(3, generatedPassword);
            ((PreparedStatement) stmt).setString(4, passwordSalt);

            ((PreparedStatement) stmt).execute();
            connection.close();

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Connection Failed " + e.getMessage());
            return false;
        }
    }
}
