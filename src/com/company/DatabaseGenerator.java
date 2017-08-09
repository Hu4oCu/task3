package com.company;

import com.company.service.TableService;
import com.company.service.impl.TableServiceImpl;
import com.company.table.Table;
import com.company.table.TableBuilder;
import com.company.table.field.Field;
import com.company.table.field.FieldBuilder;

import java.util.List;

public class DatabaseGenerator {
    private TableService service = new TableServiceImpl();

    public void createSchema(List<Table> tables) {
        for (Table table : tables) {
            Table result = new TableBuilder()
                    .buildTableName(table.getTableName())
                    .buildFields(table.getFields())
                    .buildComment(table.getComment())
                    .build();

            service.createTable(result);
        }
    }

    public void addField(String tableName, Field field) {
        Field result = new FieldBuilder()
                .buildName(field.getFieldName())
                .buildType(field.getFieldType())
                .buildComment(field.getFieldComment())
                .buildPrimaryKey(field.isPrimaryKey())
                .build();

        service.addColumn(tableName, result);
    }


//    public void addFields(String tableName, List<Field> fields) {
//        for (Field field : fields) {
//            Field result = new FieldBuilder()
//                    .buildName(field.getFieldName())
//                    .buildType(field.getFieldType())
//                    .buildComment(field.getFieldComment())
//                    .buildPrimaryKey(field.isPrimaryKey())
//                    .build();
//
//            service.addColumn(tableName, result);
//        }
//    }

}
