package gui.bookTable;


import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class BookTable extends JTable{
    public static final String[] columnsName = {"name" , "author(s)", "date", "rating", "price", "amount"};

    /*public BookTable(int numRows, int numColumns) {
        super(numRows, numColumns);
        setBookTableParameters();
    }*/

    public BookTable(int numRows) {
        super(new DefaultTableModel(columnsName, numRows));
        setBookTableParameters();
    }

    public BookTable() {}

    private void setBookTableParameters() {
        /*setShowVerticalLines(true);
        setCellSelectionEnabled(true);
        setColumnSelectionAllowed(true);*/
        setBorder(new LineBorder(Color.black));
        setFillsViewportHeight(true);
        /*DefaultTableModel defaultTableModel = (DefaultTableModel)getModel();
        defaultTableModel.addTableModelListener(new BookTableListener(this));*/
    }

}
