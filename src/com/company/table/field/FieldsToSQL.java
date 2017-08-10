package com.company.table.field;

import java.util.List;

public class FieldsToSQL {

    public String getFieldsAsString(List<Field> fields) {
        StringBuilder query = new StringBuilder("(");

        for (int index = 0; index < fields.size(); index++) {
            String fieldType = "";

            switch (fields.get(index).getFieldType()) {
                case INTEGER: {
                    fieldType = "INT(10)";
                    break;
                }
                case LONG: {
                    fieldType = "BIGINT(19)";
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

            query.append(fields.get(index).getFieldName()).append(" ").append(fieldType);
            if (fields.get(index).isPrimaryKey()) {
                query.append(" PRIMARY KEY");
            }
            if (fields.get(index).isNotNull()) {
                query.append(" NOT NULL");
            }
            if (fields.get(index).isAutoIncrement()) {
                query.append(" AUTO_INCREMENT");
            }
            if (fields.get(index).getForeignKey() != null) {
                query.append(" ,FOREIGN KEY(").append(fields.get(index).getFieldName())
                        .append(") ").append(" REFERENCES ")
                        .append(fields.get(index).getForeignKey().getTableName()).append("(")
                        .append(fields.get(index).getForeignKey().getColumnName())
                        .append(")");
            }
            if (fields.get(index).getFieldComment() != null) {
                query.append(" COMMENT '").append(fields.get(index).getFieldComment()).append("'");
            }
            if (index < fields.size() - 1) {
                query.append(", ");
            }
            else {
                query.append(") ");
            }

        }
        return query.toString();
    }

}
