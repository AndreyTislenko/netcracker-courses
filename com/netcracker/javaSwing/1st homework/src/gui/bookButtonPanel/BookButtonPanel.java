package gui.bookButtonPanel;

import gui.bookTable.BookTable;
import inputChecker.InputChecker;

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
                int indexOfRow = table.getSelectedRow();
                if(indexOfRow == -1) {
                    model.addRow(new Object[table.getColumnCount()]);
                } else {
                    model.insertRow(indexOfRow + 1, new Object[table.getColumnCount()]);
                }
            }
        });
    }

    private void createRemoveSelectedRecordButton() {
        removeSelectedRecordButton = new JButton("Remove");
        removeSelectedRecordButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel)table.getModel();
                int indexOfRow = table.getSelectedRow();

                for(int i = 0; i < table.getColumnCount(); i++) {
                    if (indexOfRow == -1) {
                        indexOfRow = table.getRowCount() - 1;
                    }
                    if(table.getValueAt(indexOfRow, i) != null) {
                        int option = JOptionPane.showConfirmDialog(table, "Are you sure?", "Warning", JOptionPane.YES_NO_OPTION);
                        if(option == JOptionPane.YES_OPTION) {
                            break;
                        } else {
                            return;
                        }
                    }
                }

                if (table.getRowCount() != 0) {
                    model.removeRow(indexOfRow);
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
