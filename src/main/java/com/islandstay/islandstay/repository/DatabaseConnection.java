package com.islandstay.islandstay.repository;
import java.sql.Connection;
import java.sql.DriverManager;

// This is a class to get a connection to MySQL database
public class DatabaseConnection {
    public static Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/islandstay",
                    "root",
                    "123456"
            );
            System.out.println("Yay! Emilyn! Successfully Connected to MySQL !");
            return connection;
        } catch (Exception e) {System.out.println("Oh! Sorry, The Database Connection Has Failed-" + e.getMessage());
            return null;}
    }
}

