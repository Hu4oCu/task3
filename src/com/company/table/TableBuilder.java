package com.company.table;

import com.company.table.field.Field;

import java.util.List;

public class TableBuilder {
    private String tableName = "";
    private List<Field> fields = null;
    private String comment = "";

    public TableBuilder tableName(String tableName) {
        this.tableName = tableName;
        return this;
    }

    public TableBuilder fields(List<Field> fields) {
        this.fields = fields;
        return this;
    }

    public TableBuilder comment(String comment) {
        this.comment = comment;
        return this;
    }

    public Table build() {
        Table table = new Table();

        table.setTableName(tableName);
        table.setFields(fields);
        table.setComment(comment);

        return table;
    }
}
