package gui.bookButtonPanel;

import gui.bookTable.BookTable;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BookButtonPanel extends JPanel {
    private BookTable table;
    private JButton addRecordButton;
    private JButton removeSelectedRecordButton;

    public BookButtonPanel(JTabbedPane bookTabbedPane) {
        JScrollPane tableScroll = (JScrollPane)bookTabbedPane.getSelectedComponent();
        JViewport viewport = tableScroll.getViewport();
        table = (BookTable)viewport.getView();

        bookTabbedPane.addChangeListener(new SelectedBookTableListener());

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createAddRecordButton();
        createRemoveSelectedRecordButton();

        JPanel gridButtonPanel = new JPanel(new GridLayout(2,1,0,5));
        gridButtonPanel.add(addRecordButton);
        gridButtonPanel.add(removeSelectedRecordButton);

        JPanel flow = new JPanel();
        flow.add(gridButtonPanel);

        add(flow);
    }

    private void createAddRecordButton() {
        addRecordButton = new JButton("Add");
        addRecordButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                model.addRow(new Object[table.getColumnCount()]);
            }
        });
    }

    private void createRemoveSelectedRecordButton() {
        removeSelectedRecordButton = new JButton("Remove");
        removeSelectedRecordButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                int indexOfColumn = table.getSelectedRow();
                if (indexOfColumn != -1) {
                    model.removeRow(table.getSelectedRow());
                } else if(table.getRowCount() != 0){
                    model.removeRow(table.getRowCount() - 1);
                }
            }
        });
    }

    public BookTable getTable() {
        return table;
    }

    public void setTable(BookTable table) {
        this.table = table;
    }

    private class SelectedBookTableListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            JTabbedPane bookTabbedPane = (JTabbedPane)e.getSource();
            JScrollPane tableScroll = (JScrollPane)bookTabbedPane.getSelectedComponent();
            JViewport viewport = tableScroll.getViewport();
            table = (BookTable)viewport.getView();
        }
    }
}
