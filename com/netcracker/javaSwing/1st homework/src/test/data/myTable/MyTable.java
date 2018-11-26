package test.data.myTable;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class MyTable {
    private String[] columns;
    private Field[] types;
    private ArrayList<Object[]> records;

    public MyTable(String... columns) {
        records = new ArrayList<>();
        this.columns = columns;
    }

    public void setTypesForColumns(Field... types){
        this.types = types;
    }

    public void addRow(Object[] record) {
        recordValidation(record);
        records.add(record);
    }

    public void addRows(Object[][] records) {
        for (int i = 0; i < records.length; i++) {
            addRow(records[i]);
        }
    }

    private void recordValidation(Object[] record) {
        if (record.length != columns.length)
            throw new RuntimeException("record length exception");
        else {
            for (int i = 0; i < record.length; i++) {
                String typeOfFieldInRecord = record.getClass().getTypeName();
                String typeOfFieldInRow = types[i].getName();
                if (!typeOfFieldInRecord.equals(typeOfFieldInRow)) {
                    throw new RuntimeException("incompatible type: " + record[i] + " and " + typeOfFieldInRow);
                }
            }
        }
    }

    public String[] getColumns() { return columns; }
    public void setColumns(String[] columns) {
        this.columns = columns;
    }
    public Field[] getTypes() {
        return types;
    }
    public void setTypes(Field[] types) {
        this.types = types;
    }
    public ArrayList<Object[]> getRecords() {
        return records;
    }
    public void setRecords(ArrayList<Object[]> records) {
        this.records = records;
    }

    public Object[][] getDoubleArrayTable(){
        Object[][] elements = new Object[records.size()][columns.length];
        for (int i = 0; i < records.size(); i++) {
            elements[i] = records.get(i);
        }
        return  elements;
    }
}
