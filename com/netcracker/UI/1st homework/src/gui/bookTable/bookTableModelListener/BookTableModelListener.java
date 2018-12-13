package gui.bookTable.bookTableModelListener;

import bookTableFile.bookTableFileSerializer.BookTableFileSerializer;
import gui.bookMainFrame.MainFrame;
import gui.bookTable.BookTable;
import inputChecker.InputChecker;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.io.File;

public class BookTableModelListener implements TableModelListener {
    private BookTable bookTable;
    private int indexOfSelectedTab;
    private int indexOfDefaultTab;

    public BookTableModelListener(BookTable bookTable, int indexOfSelectedTab) {
        indexOfDefaultTab = 0;
        this.indexOfSelectedTab = indexOfSelectedTab;
        this.bookTable = bookTable;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int indexOfColumn = bookTable.getSelectedColumn();
        int indexOfRow = bookTable.getSelectedRow();
        String field = null;

        if(bookTable.isCellSelected(indexOfRow, indexOfColumn)) {
            /* This condition is important for correct working of remove button, when the last row is selected
             * for remove (without selection remove button works pretty well). I think it's because the method
             * tableChanged is triggered at the same time as removing proses and indexOfRow doesn't have time to
             * change.*/
            if(indexOfRow == bookTable.getRowCount()) indexOfRow--;

            field = (String) bookTable.getValueAt(indexOfRow, indexOfColumn);
        }

        if(!(field == null)) {
            InputChecker inputChecker = new InputChecker(BookTable.columnsName);

            if (inputChecker.checkInputForColumn(indexOfColumn, field)) {
                if(indexOfSelectedTab == indexOfDefaultTab) {
                    BookTableFileSerializer serializer = new BookTableFileSerializer(new File(MainFrame.defaultUrlWithSpaces), bookTable);
                    serializer.save();
                }
            } else {
                JOptionPane.showMessageDialog(bookTable, "Incorrect input at column " + bookTable.getColumnName(indexOfColumn) +
                                ", row = " + indexOfRow + ".\n Please try again.",
                        "Incorrect input", JOptionPane.WARNING_MESSAGE);
                DefaultTableModel tableModel = (DefaultTableModel) bookTable.getModel();
                tableModel.setValueAt(null, indexOfRow, indexOfColumn);
            }
        }
    }
}