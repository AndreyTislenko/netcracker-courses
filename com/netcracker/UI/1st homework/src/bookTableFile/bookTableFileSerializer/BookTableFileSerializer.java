package bookTableFile.bookTableFileSerializer;

import gui.bookTable.BookTable;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;

public class BookTableFileSerializer {
    private File filePath;
    private Object[][] bookTableData;

    public BookTableFileSerializer(File filePath, BookTable bookTable) {
        this.filePath = filePath;
        this.bookTableData = getTableData(bookTable);
    }

    public void save(){
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath));
            objectOutputStream.writeObject(bookTableData);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object[][] getTableData (JTable table) {
        DefaultTableModel dtm = (DefaultTableModel)table.getModel();
        int nRow = dtm.getRowCount(), nCol = dtm.getColumnCount();
        Object[][] tableData = new Object[nRow][nCol];
        for (int i = 0 ; i < nRow ; i++)
            for (int j = 0 ; j < nCol ; j++)
                tableData[i][j] = dtm.getValueAt(i,j);
        return tableData;
    }

}
