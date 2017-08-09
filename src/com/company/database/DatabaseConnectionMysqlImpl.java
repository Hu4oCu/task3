package com.company.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionMysqlImpl implements DatabaseConnection {

    @Override
    public Connection getConnection(String dbName, String dbUser, String dbPassword) {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Mysql JDBC driver not found");
            e.printStackTrace();
        }

        try {
            con = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", dbUser, dbPassword);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        return con;
    }
}
