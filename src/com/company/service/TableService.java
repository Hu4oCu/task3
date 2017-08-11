package com.company.service;

import com.company.table.field.Field;
import com.company.table.Table;

public interface TableService {
    void createTable(Table table);
    void alterTable(Table table);
    boolean tableExists(Table table);
    void addColumn(String tableName, Field field);
    void changeColumnType(Table table, Field field);
}
