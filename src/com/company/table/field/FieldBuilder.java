package com.company.table.field;

public class FieldBuilder {
    private String fieldName = "";
    private FieldType fieldType = FieldType.INTEGER;
    private String fieldComment = "";
    private boolean primaryKey = false;
    private boolean notNull = false;
    private boolean autoIncrement;
    private ForeignKey foreignKey;

    public FieldBuilder fieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public FieldBuilder fieldType(FieldType fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    public FieldBuilder fieldComment(String fieldComment) {
        this.fieldComment = fieldComment;
        return this;
    }

    public FieldBuilder primaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }

    public FieldBuilder notNull(boolean notNull) {
        this.notNull = notNull;
        return this;
    }

    public FieldBuilder autoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
        return this;
    }

    public FieldBuilder foreignKey(ForeignKey foreignKey) {
        this.foreignKey = foreignKey;
        return this;
    }

    public Field build() {
        Field field = new Field();

        field.setFieldName(fieldName);
        field.setFieldType(fieldType);
        field.setFieldComment(fieldComment);
        field.setPrimaryKey(primaryKey);
        field.setNotNull(notNull);
        field.setAutoIncrement(autoIncrement);
        field.setForeignKey(foreignKey);

        return field;
    }


}
