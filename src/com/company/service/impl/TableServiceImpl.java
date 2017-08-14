package com.company.service.impl;

import com.company.database.DatabaseConnection;
import com.company.database.DatabaseConnectionMysqlImpl;
import com.company.service.TableService;
import com.company.table.field.Field;
import com.company.table.Table;
import com.company.ParseToSQL;
import java.sql.*;
import java.util.List;

public class TableServiceImpl implements TableService {
    private static final String DB_NAME = "task3";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "rootroot";
    private DatabaseConnection databaseConnectionMysql = new DatabaseConnectionMysqlImpl();
    private DatabaseMetaData metaData;
    private Statement statement = null;
    private ParseToSQL parseToSQL = new ParseToSQL();

    @Override
    public void createTable(Table table) {
        try {
            Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);
            statement = con.createStatement();

            if (tableExists(table)){
                alterTable(table);
            } else {
                statement.execute(parseToSQL.getCreateTableQuery(table));
            }

            System.out.println(parseToSQL.getCreateTableQuery(table));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void alterTable(Table table) {
        List<Field> fields = table.getFields();
        for (Field field : fields) {
            try {
                ResultSet resultSet = metaData.getColumns(null, null, table.getTableName(), field.getFieldName());

                if (resultSet.next()) {
                    String currentFieldType = resultSet.getString("TYPE_NAME");
                    if (!currentFieldType.equals(parseToSQL.getFieldTypeWithoutEOF(field))) {
                        changeColumnType(table, field);
                    }
                } else {
                    addColumn(table.getTableName(), field);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public boolean tableExists(Table table) {
        try {
            Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);

            metaData = con.getMetaData();

            ResultSet resultSet = metaData.getTables(null, null, table.getTableName(), null);

            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void addColumn(String tableName, Field field) {
        Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);

        try {
            statement = con.createStatement();
            statement.execute(parseToSQL.getAddColumnQuery(tableName, field));
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void changeColumnType(Table table, Field field) {
        Connection con = databaseConnectionMysql.getConnection(DB_NAME, DB_USER, DB_PASSWORD);

        try {
            statement = con.createStatement();
            statement.execute(parseToSQL.getChangeColumnTypeQuery(table, field));
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
