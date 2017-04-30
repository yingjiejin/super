package com.supermarket.generator.utils;

import com.supermarket.generator.core.Column;
import com.supermarket.generator.core.Table;
import org.apache.commons.lang3.StringUtils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableUtils {

    public static Table warp(ResultSet rs) throws SQLException {
        Table table = new Table();
        table.setName(rs.getString("TABLE_NAME"));
        table.setComment(rs.getString("REMARKS"));
        return table;
    }

    public static List<Table> loadTables(Connection conn, String user) throws SQLException {

        List<Table> tables = new ArrayList<Table>();
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getTables(conn.getCatalog(), user, null, new String[]{"TABLE"});
        while (rs.next()) {
            Table table = warp(rs);
            table.setColumns(loadColumns(conn, table.getName(), user));
            tables.add(table);
        }

        return tables;
    }

    public static List<Column> loadColumns(Connection conn, String table, String user) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();
        ResultSet rs = metaData.getColumns(conn.getCatalog(), null, table, null);
        List<Column> columns = new ArrayList<Column>();
        while (rs.next()) {
            Column column = warpColumn(rs);
            ResultSet pkRSet = metaData.getPrimaryKeys(null, null, table);
            if (pkRSet.next()) {
                column.setKey(StringUtils.equalsIgnoreCase(pkRSet.getString("COLUMN_NAME"), column.getName()));
            }
            columns.add(column);
        }
        return columns;
    }

    private static Column warpColumn(ResultSet colrs) throws SQLException {
        Column column = new Column();
        if (colrs.next()) {
            column.setComment(colrs.getString("REMARKS"));
            column.setName(colrs.getString("COLUMN_NAME"));
            column.setType(colrs.getString("TYPE_NAME"));
            // column.setKey(key);
            // System.out.println("TABLE_CAT" + "===" +
            // colrs.getString("TABLE_CAT"));
            // System.out.println("TABLE_SCHEM" + "===" +
            // colrs.getString("TABLE_SCHEM"));
            // System.out.println("TABLE_NAME" + "===" +
            // colrs.getString("TABLE_NAME"));
            // System.out.println("COLUMN_NAME" + "===" +
            // colrs.getString("COLUMN_NAME"));
            // System.out.println("DATA_TYPE" + "===" +
            // colrs.getString("DATA_TYPE"));
            // System.out.println("TYPE_NAME" + "===" +
            // colrs.getString("TYPE_NAME"));
            // System.out.println("COLUMN_SIZE" + "===" +
            // colrs.getString("COLUMN_SIZE"));
            // System.out.println("BUFFER_LENGTH" + "===" +
            // colrs.getString("BUFFER_LENGTH"));
            // System.out.println("DECIMAL_DIGITS" + "===" +
            // colrs.getString("DECIMAL_DIGITS"));
            // System.out.println("NUM_PREC_RADIX" + "===" +
            // colrs.getString("NUM_PREC_RADIX"));
            // System.out.println("NULLABLE" + "===" +
            // colrs.getString("NULLABLE"));
            // System.out.println("REMARKS" + "===" +
            // colrs.getString("REMARKS"));
            // System.out.println("COLUMN_DEF" + "===" +
            // colrs.getString("COLUMN_DEF"));
            // System.out.println("SQL_DATA_TYPE" + "===" +
            // colrs.getString("SQL_DATA_TYPE"));
            // System.out.println("SQL_DATETIME_SUB" + "===" +
            // colrs.getString("SQL_DATETIME_SUB"));
            // System.out.println("CHAR_OCTET_LENGTH" + "===" +
            // colrs.getString("CHAR_OCTET_LENGTH"));
            // System.out.println("ORDINAL_POSITION" + "===" +
            // colrs.getString("ORDINAL_POSITION"));
            // System.out.println("IS_NULLABLE" + "===" +
            // colrs.getString("IS_NULLABLE"));
            // System.out.println("SCOPE_CATALOG" + "===" +
            // colrs.getString("SCOPE_CATALOG"));
            // System.out.println("SCOPE_SCHEMA" + "===" +
            // colrs.getString("SCOPE_SCHEMA"));
            // System.out.println("SCOPE_TABLE" + "===" +
            // colrs.getString("SCOPE_TABLE"));
            // System.out.println("SOURCE_DATA_TYPE" + "===" +
            // colrs.getString("SOURCE_DATA_TYPE"));
            // System.out.println("IS_AUTOINCREMENT" + "===" +
            // colrs.getString("IS_AUTOINCREMENT"));
        }
        return column;
    }

}
