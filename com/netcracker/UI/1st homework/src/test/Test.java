package test;

import test.data.author.Author;
import test.data.book.Book;
import test.data.myTable.MyTable;
import test.data.objectTableConverter.ObjectTableConverter;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Date;

public class Test {

    public void testTable(JFrame mainFrame) {
        Book[] books = createDefaultArrayOfBooks(20);
        JTable tableSample = createJTableForBooks(books);
        JScrollPane jScrollPane = new JScrollPane(tableSample);

        mainFrame.getContentPane().add(BorderLayout.WEST, new JScrollPane(jScrollPane));
    }

    private Book[] createDefaultArrayOfBooks(int length) {
        Book[] books = new Book[length];
        for (int i = 0; i < books.length; i++) {
            books[i] = new Book("Book "+i, new Author[]{new Author("Oscar", "Wild")}, new BigDecimal(4.99 + i));
            books[i].setDate(new Date(1819 + i*10, (i+1)%12, (i+1)%31));
            books[i].setAmountOfBooks(1);
        }
        return  books;
    }

    private JTable createJTableForBooks(Book[] books) {
        Field[] fields = books[0].getClass().getDeclaredFields();
        String[] columnsName = new String[fields.length];
        for (int i = 0; i < columnsName.length; i++) {
            columnsName[i] = fields[i].getName();
        }
        ObjectTableConverter<Book> objectTableConverter = new ObjectTableConverter<>(columnsName, books);
        MyTable table = objectTableConverter.getMyTableOfObjects();
        return new JTable(table.getDoubleArrayTable(), table.getColumns());
    }
}
