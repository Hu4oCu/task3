package com.company.database;

import java.sql.Connection;

public interface DatabaseConnection {
    Connection getConnection(String dbName, String dbUser, String dbPassword);
}
