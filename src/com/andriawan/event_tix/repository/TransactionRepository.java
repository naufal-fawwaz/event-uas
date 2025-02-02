package com.andriawan.event_tix.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.andriawan.event_tix.data.DBConn;
import com.andriawan.event_tix.models.Event;
import com.andriawan.event_tix.models.Transaction;
import com.andriawan.event_tix.models.User;

public class TransactionRepository extends DBConn {
    
    public List<Transaction> getListTransactions() {
        try {
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT events.id, events.title, events.description, events.quota, events.status, events.type, events.price, events.event_time, users.name, users.email, users.role, users.password, users.created_at, users.updated_at, transactions.id, transactions.status, transactions.deadline, transactions.amount FROM transactions INNER JOIN events ON events.id = transactions.events_id INNER JOIN users ON users.id = transactions.users_id;");
            List<Transaction> list = new ArrayList<>();
            
            while (resultSet.next()) {
                Event event = new Event(
                    resultSet.getInt(1), 
                    resultSet.getString(2), 
                    resultSet.getString(3), 
                    resultSet.getInt(4), 
                    resultSet.getString(5), 
                    resultSet.getString(6), 
                    resultSet.getInt(7), 
                    resultSet.getString(8)
                );

                User user = new User(
                    resultSet.getString(9), 
                    resultSet.getString(10), 
                    resultSet.getString(11), 
                    resultSet.getString(12), 
                    resultSet.getString(13), 
                    resultSet.getString(14)
                );

                Transaction transaction = new Transaction(
                    resultSet.getInt(15), 
                    event, 
                    user, 
                    resultSet.getString(16), 
                    resultSet.getString(17), 
                    resultSet.getInt(18)
                );

                list.add(transaction);
            }

            connection.close();
            stmt.close();
            resultSet.close();

            return list;
        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null, "Connection Failed " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public Transaction getTransaction(int transactionId) {
        try {
            stmt = connection.createStatement();
            resultSet = stmt.executeQuery("SELECT events.id, events.title, events.description, events.quota, events.status, events.type, events.price, events.event_time, users.name, users.email, users.role, users.password, users.created_at, users.updated_at, transactions.id, transactions.status, transactions.deadline, transactions.amount FROM transactions INNER JOIN events ON events.id = transactions.events_id INNER JOIN users ON users.id = transactions.users_id WHERE transactions.id = " + transactionId);
            List<Transaction> list = new ArrayList<>();
            
            while (resultSet.next()) {
                Event event = new Event(
                    resultSet.getInt(1), 
                    resultSet.getString(2), 
                    resultSet.getString(3), 
                    resultSet.getInt(4), 
                    resultSet.getString(5), 
                    resultSet.getString(6), 
                    resultSet.getInt(7), 
                    resultSet.getString(8)
                );

                User user = new User(
                    resultSet.getString(9), 
                    resultSet.getString(10), 
                    resultSet.getString(11), 
                    resultSet.getString(12), 
                    resultSet.getString(13), 
                    resultSet.getString(14)
                );

                Transaction transaction = new Transaction(
                    resultSet.getInt(15), 
                    event, 
                    user, 
                    resultSet.getString(16), 
                    resultSet.getString(17), 
                    resultSet.getInt(18)
                );

                list.add(transaction);
            }

            connection.close();
            stmt.close();
            resultSet.close();

            if (!list.isEmpty()) {
                return list.get(0);
            } else {
             JOptionPane.showMessageDialog(null, "Transaksi tidak ditemukan");
                return null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Connection Failed " + e.getMessage());
            return null;
        }
    }
}
