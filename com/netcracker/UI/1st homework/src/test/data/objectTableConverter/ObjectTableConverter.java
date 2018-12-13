package test.data.objectTableConverter;

import test.data.myTable.MyTable;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class ObjectTableConverter<T> {
    private MyTable myTableOfObjects;
    private T[] objects;

    public ObjectTableConverter(String[] columnNames, T[] objects) {
        myTableOfObjects = new MyTable(columnNames);
        objectsToTable(objects);
    }

    private void objectsToTable(T[] objects) {
        ArrayList<Object[]> records = new ArrayList<>();
        for (T object: objects) {
            Field[] record = object.getClass().getDeclaredFields();
            Object[] fieldsOfObject = new Object[record.length];

            for (int i = 0; i < record.length; i++) {
                try {
                    record[i].setAccessible(true);
                    fieldsOfObject[i] = record[i].get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            records.add(fieldsOfObject);
        }
        myTableOfObjects.setRecords(records);
    }

    public MyTable getMyTableOfObjects() {
        return myTableOfObjects;
    }
    public void setMyTableOfObjects(MyTable myTableOfObjects) {
        this.myTableOfObjects = myTableOfObjects;
    }
    public T[] getObjects() {
        return objects;
    }
    public void setObjects(T[] objects) {
        this.objects = objects;
    }
}
