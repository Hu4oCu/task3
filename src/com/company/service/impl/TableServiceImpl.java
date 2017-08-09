package com.company.service.impl;

import com.company.database.DatabaseConnection;
import com.company.database.DatabaseConnectionMysqlImpl;
import com.company.service.TableService;
import com.company.table.field.Field;
import com.company.table.Table;
import com.company.table.field.FieldsToSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableServiceImpl implements TableService {
    private static final String DB_NAME = "task3";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "rootroot";

    private DatabaseConnection databaseConnectionMysql = new DatabaseConnectionMysqlImpl();
    private Statement statement = null;

    @Override
    public void createTable(Table table) {
        Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
        StringBuilder sqlQuery = new StringBuilder();

        FieldsToSQL fieldsToSQL = new FieldsToSQL();

        try {
            sqlQuery.append("CREATE TABLE IF NOT EXISTS ").append(table.getTableName())
                    .append(" ").append(fieldsToSQL.getFieldsAsString(table.getFields()));
            if (table.getComment() != null) {
                sqlQuery.append(" COMMENT '").append(table.getComment()).append("'");
            }

            statement = con.createStatement();
            statement.execute(sqlQuery.toString());

            System.out.println(sqlQuery);
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dropTable(String tableName) {
        Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
        StringBuilder sqlQuery = new StringBuilder();

        try {
            sqlQuery.append("DROP TABLE IF EXISTS ").append(tableName);

            statement = con.createStatement();
            statement.execute(sqlQuery.toString());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void addColumn(String tableName, Field field) {
        Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
        StringBuilder sqlQuery = new StringBuilder();

        try {
            sqlQuery.append("ALTER TABLE ").append(tableName).append(" ADD COLUMN ")
                    .append(field.getFieldName()).append(" ").append(field.getFieldType());
            if (field.isPrimaryKey()) sqlQuery.append(" PRIMARY KEY");
            if (field.getFieldComment() != null) sqlQuery.append(" COMMENT '").append(field.getFieldComment())
                    .append("'");

            statement = con.createStatement();
            statement.execute(sqlQuery.toString());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropColumn(String tableName, String fieldName) {
        Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
        StringBuilder sqlQuery = new StringBuilder();

        try {
            sqlQuery.append("ALTER TABLE ").append(tableName).append(" DROP COLUMN ").append(fieldName);

            statement = con.createStatement();
            statement.execute(sqlQuery.toString());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeColumn(String tableName, String tableName2, Field field) {
        Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
        StringBuilder sqlQuery = new StringBuilder();

        try {
            sqlQuery.append("ALTER TABLE ").append(tableName).append(" ").append(tableName2)
                    .append(" ").append(field.getFieldType());

            statement = con.createStatement();
            statement.execute(sqlQuery.toString());
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
