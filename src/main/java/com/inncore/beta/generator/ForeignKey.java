package com.inncore.beta.generator;

import com.baomidou.mybatisplus.generator.config.po.TableInfo;

public class ForeignKey {

    private String tableName;
    private String column;
    private String foreignTableName;
    private String foreignColumn;
    private String foreignClassName;
    private TableInfo foreignTableInfo;

    public ForeignKey() {

    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getForeignTableName() {
        return foreignTableName;
    }

    public void setForeignTableName(String foreignTableName) {
        this.foreignTableName = foreignTableName;
    }

    public String getForeignColumn() {
        return foreignColumn;
    }

    public void setForeignColumn(String foreignColumn) {
        this.foreignColumn = foreignColumn;
    }

    public String getForeignClassName() {
        return foreignClassName;
    }

    public void setForeignClassName(String foreignClassName) {
        this.foreignClassName = foreignClassName;
    }

    public TableInfo getForeignTableInfo() {
        return foreignTableInfo;
    }

    public void setForeignTableInfo(TableInfo foreignTableInfo) {
        this.foreignTableInfo = foreignTableInfo;
    }

    @Override
    public String toString() {
        return "ForeignKey{" +
                "tableName='" + tableName + '\'' +
                ", column='" + column + '\'' +
                ", foreignTableName='" + foreignTableName + '\'' +
                ", foreignColumn='" + foreignColumn + '\'' +
                ", foreignClassName='" + foreignClassName + '\'' +
                ", foreignTableInfo=" + foreignTableInfo +
                '}';
    }
}
