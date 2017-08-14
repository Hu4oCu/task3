package com.company.table.field;

public class FieldBuilder {
    private String fieldName = "";
    private FieldType fieldType = FieldType.SIGNED_INTEGER;
    private String fieldComment = "";
    private boolean primaryKey = false;
    private boolean notNull = false;
    private boolean autoIncrement = false;
    private ForeignKey foreignKey = null;

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

    public FieldBuilder primaryKey() {
        this.primaryKey = true;
        return this;
    }

    public FieldBuilder notNull() {
        this.notNull = true;
        return this;
    }

    public FieldBuilder autoIncrement() {
        this.autoIncrement = true;
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
