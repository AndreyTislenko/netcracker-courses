package com.netcracker.model;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Comparator;

public class TableSorter {
    private Table table;
    private String sortColumn;

    public TableSorter() {}

    public Table getTable() { return table; }
    public void setTable(Table table) {
        this.table = table;
    }
    public String getSortColumn() {
        return sortColumn;
    }
    public void setSortColumn(String sortColumn) {
        this.sortColumn = sortColumn;
    }

    public Table sortTable() {
        try{
            Field field = Book.class.getDeclaredField(sortColumn);
            field.setAccessible(true);

            Collections.sort(table.getRecords(), new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    Comparable value1 = null;
                    Comparable value2 = null;
                    try{
                        value1 = (Comparable) field.get(o1);
                        value2 = (Comparable) field.get(o2);
                    }catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    return value1.compareTo(value2);
                }
            });
        }catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return table;
    }
}
