package com.company;

import com.company.table.field.Field;
import com.company.table.field.FieldBuilder;
import com.company.table.field.FieldType;

public class Main {
    public static void main(String[] args) {
        Tables tables = new Tables();

        tables.createTables();

        DatabaseGenerator generator = new DatabaseGenerator(tables.getTables());
        generator.createTables();

        Field newField = new FieldBuilder()
                .fieldName("new_field")
                .fieldType(FieldType.STRING)
                .fieldComment("test field")
                .build();

        generator.addField("students", newField);
    }
}
