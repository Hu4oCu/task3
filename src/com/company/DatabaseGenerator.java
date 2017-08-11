package com.company;

import com.company.service.TableService;
import com.company.service.impl.TableServiceImpl;
import com.company.table.Table;
import com.company.table.field.Field;

import java.util.ArrayList;
import java.util.List;

public class DatabaseGenerator {
    private List<Table> tables = new ArrayList<>();
    private List<Table> sortedTables = new ArrayList<>();
    private TableService service = new TableServiceImpl();

    public DatabaseGenerator(List<Table> tables) {
        this.tables = tables;
    }

    public void createTables() {
        tables.forEach(this::sortTables);

        for (Table table : sortedTables) {
            service.createTable(table);
        }
    }

    private void sortTables(Table table){
        if (sortedTables.contains(table)) return;

        table.getFields().stream().filter(field -> field.getForeignKey() != null).forEach(field -> {
            Table referenceTable = getReferenceTable(field);
            sortTables(referenceTable);
        });

        sortedTables.add(table);
    }

    private Table getReferenceTable(Field field){
        String tableName = field.getForeignKey().getReferenceTableName();
        for (Table table : tables){
            if (table.getTableName().equals(tableName))
                return table;
        }
        return null;
    }

    public void addField(String tableName, Field field) {
        service.addColumn(tableName, field);
    }



}
