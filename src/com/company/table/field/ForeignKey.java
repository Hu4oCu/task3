package com.company.table.field;

public class ForeignKey {
    private String referenceTableName;
    private String columnName;

    public ForeignKey(String referenceTableName, String columnName) {
        this.referenceTableName = referenceTableName;
        this.columnName = columnName;
    }

    public String getReferenceTableName() {
        return referenceTableName;
    }

    public void setReferenceTableName(String referenceTableName) {
        this.referenceTableName = referenceTableName;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }
}

