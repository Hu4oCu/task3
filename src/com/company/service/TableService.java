package com.company.service;

import com.company.table.field.Field;
import com.company.table.Table;

public interface TableService {
    void createTable(Table table);
    void dropTable(String tableName);
    void addColumn(String tableName, Field field);
    void dropColumn(String tableName, String fieldName);
    void changeColumn(String tableName, String tableName2, Field field);
}
