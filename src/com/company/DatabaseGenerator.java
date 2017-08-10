package com.company;

import com.company.service.TableService;
import com.company.service.impl.TableServiceImpl;
import com.company.table.Table;
import com.company.table.field.Field;
import java.util.List;

public class DatabaseGenerator {
    private TableService service = new TableServiceImpl();

    public void createSchemas(List<Table> tables) {
        for (Table table : tables) {
            service.createTable(table);
        }
    }

    public void addField(String tableName, Field field) {
        service.addColumn(tableName, field);
    }


//    public void addFields(String tableName, List<Field> fields) {
//        for (Field field : fields) {
//            Field result = new FieldBuilder()
//                    .name(field.getFieldName())
//                    .type(field.getFieldType())
//                    .comment(field.getFieldComment())
//                    .primaryKey(field.isPrimaryKey())
//                    .foreignKey(field.getForeignKey())
//                    .build();
//
//            service.addColumn(tableName, result);
//        }
//    }

}
