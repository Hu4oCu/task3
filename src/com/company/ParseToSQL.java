package com.company;

import com.company.table.Table;
import com.company.table.field.Field;

public class ParseToSQL {

    public String getCreateTableQuery(Table table) {
        StringBuilder sqlQuery = new StringBuilder();

        sqlQuery.append("CREATE TABLE IF NOT EXISTS ").append(table.getTableName())
                .append(" (");

        for (int i = 0; i < table.getFields().size(); i++) {
            sqlQuery.append(getFieldQuery(table.getFields().get(i)));
            if (i < table.getFields().size() - 1) {
                sqlQuery.append(",");
            } else {
                sqlQuery.append(")");
            }
        }

        if (table.getComment() != null) {
            sqlQuery.append(" COMMENT '").append(table.getComment()).append("';\n");
        } else {
            sqlQuery.append(";\n");
        }

        System.out.println(sqlQuery);

        return sqlQuery.toString();
    }

    public String getFieldQuery(Field field) {
        StringBuilder query = new StringBuilder("");

        query.append("\n").append(field.getFieldName()).append(" ").append(getFieldType(field));
        if (field.isPrimaryKey()) {
            query.append(" PRIMARY KEY");
        }
        if (field.isNotNull()) {
            query.append(" NOT NULL");
        }
        if (field.isAutoIncrement()) {
            query.append(" AUTO_INCREMENT");
        }
        if (!field.getFieldComment().isEmpty()) {
            query.append(" COMMENT '").append(field.getFieldComment()).append("'");
        }
        if (field.getForeignKey() != null) {
            query.append(", \nFOREIGN KEY (").append(field.getFieldName())
                    .append(")").append(" REFERENCES ")
                    .append(field.getForeignKey().getReferenceTableName()).append("(")
                    .append(field.getForeignKey().getColumnName())
                    .append(")");
        }

        return query.toString();
    }

    public String getAddColumnQuery(String tableName, Field field) {
        StringBuilder query = new StringBuilder("ALTER TABLE ");

        query.append(tableName).append(" ADD COLUMN ").append(getFieldQuery(field));

        System.out.println("ADD COLUMN QUERY = " + query);

        return query.toString();
    }

    public String getChangeColumnTypeQuery(Table table, Field field) {
        StringBuilder query = new StringBuilder("ALTER TABLE ");

        query.append(table.getTableName()).append(" MODIFY COLUMN ")
                .append(field.getFieldName()).append(" ").append(getFieldType(field));

        return query.toString();
    }

    public String getFieldTypeWithoutEOF(Field field) {
        String fieldType = "";

        switch (field.getFieldType()) {
            case SIGNED_INTEGER: {
                fieldType = "INT";
                break;
            }
            case UNSIGNED_INTEGER: {
                fieldType = "INT UNSIGNED";
                break;
            }
            case LONG: {
                fieldType = "BIGINT";
                break;
            }
            case FLOAT: {
                fieldType = "DECIMAL";
                break;
            }
            case DOUBLE: {
                fieldType = "DECIMAL";
                break;
            }
            case STRING: {
                fieldType = "VARCHAR";
                break;
            }
            case DATE: {
                fieldType = "DATE";
                break;
            }
            case DATETIME: {
                fieldType = "DATETIME";
                break;
            }
            case TIMESTAMP: {
                fieldType = "TIMESTAMP";
                break;
            }
            case YEAR: {
                fieldType = "YEAR";
                break;
            }
        }

        return fieldType;
    }

    public String getFieldType(Field field) {
        String fieldType = "";

        switch (field.getFieldType()) {
            case SIGNED_INTEGER: {
                fieldType = "INT";
                break;
            }
            case UNSIGNED_INTEGER: {
                fieldType = "INT UNSIGNED";
                break;
            }
            case LONG: {
                fieldType = "BIGINT";
                break;
            }
            case FLOAT: {
                fieldType = "DECIMAL(10,6)";
                break;
            }
            case DOUBLE: {
                fieldType = "DECIMAL(19,6)";
                break;
            }
            case STRING: {
                fieldType = "VARCHAR(255)";
                break;
            }
            case DATE: {
                fieldType = "DATE";
                break;
            }
            case DATETIME: {
                fieldType = "DATETIME";
                break;
            }
            case TIMESTAMP: {
                fieldType = "TIMESTAMP";
                break;
            }
            case YEAR: {
                fieldType = "YEAR";
                break;
            }
        }

        return fieldType;
    }
}
