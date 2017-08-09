package com.company.table.field;

public class FieldBuilder {
    private String fieldName = "";
    private FieldType fieldType = FieldType.INTEGER;
    private String fieldComment = "";
    private boolean primaryKey = false;
    private ForeignKey foreignKey = null;

    public FieldBuilder buildName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public FieldBuilder buildType(FieldType fieldType) {
        this.fieldType = fieldType;
        return this;
    }

    public FieldBuilder buildComment(String fieldComment) {
        this.fieldComment = fieldComment;
        return this;
    }

    public FieldBuilder buildPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
        return this;
    }

    public FieldBuilder buildForeignKey(ForeignKey foreignKey) {
        this.foreignKey = foreignKey;
        return this;
    }

    public Field build() {
        Field field = new Field();

        field.setFieldName(fieldName);
        field.setFieldType(fieldType);
        field.setFieldComment(fieldComment);
        field.setPrimaryKey(primaryKey);
        field.setForeignKey(foreignKey);

        return field;
    }


}
