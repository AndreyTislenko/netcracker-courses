package com.netcracker.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Table {
    private String[] columnNames = {"id", "author", "name", "pages", "date of publishing", "date of adding"};
    private ArrayList<Book> records = new ArrayList<>();

    public Table() {}

    public String[] getColumnNames() { return columnNames; }
    public void setColumnNames(String[] columnNames) {
        this.columnNames = columnNames;
    }
    public ArrayList<Book> getRecords() {
        return records;
    }
    public void setRecords(ArrayList<Book> records) {
        this.records = records;
    }

    public static Table createDefaultTable() {
        Table table = new Table();
        table.getRecords().add(new Book(1, "George Orwell", "1984", 110, new GregorianCalendar(1949,1,1),new GregorianCalendar(2008, 9,12)));
        table.getRecords().add(new Book(2, "Oscar Wild", "The picture of Dorian Gray", 150, new GregorianCalendar(1890, 1, 1),new GregorianCalendar(2017, 12, 1)));
        table.getRecords().add(new Book(3, "Erich Maria Remarque", "Three Comrades", 257, new GregorianCalendar(1936, 1, 1),new GregorianCalendar(2018,5, 25)));
        return table;
    }
}