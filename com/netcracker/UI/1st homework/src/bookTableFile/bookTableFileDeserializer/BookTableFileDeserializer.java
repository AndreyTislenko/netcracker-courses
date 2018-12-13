package bookTableFile.bookTableFileDeserializer;

import gui.bookTable.BookTable;

import javax.swing.table.DefaultTableModel;
import java.io.*;

public class BookTableFileDeserializer {
    private File filePath;
    private Object[][] bookTableData;

    public BookTableFileDeserializer(File filePath) {
        this.filePath = filePath;
    }

    public void open() {
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
            bookTableData = (Object[][])objectInputStream.readObject();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public BookTable getBookTable() {
        BookTable bookTable = new BookTable();
        bookTable.setModel(new DefaultTableModel(bookTableData, BookTable.columnsName));
        return bookTable;
    }
}
