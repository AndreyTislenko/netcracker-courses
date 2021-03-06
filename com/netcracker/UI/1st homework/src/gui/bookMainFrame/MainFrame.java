package gui.bookMainFrame;

import bookTableFile.bookTableFileDeserializer.BookTableFileDeserializer;
import gui.bookButtonPanel.BookButtonPanel;
import gui.bookMenuBar.BookMenuBar;
import gui.bookTable.BookTable;
import gui.bookTable.bookTableModelListener.BookTableModelListener;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

public class MainFrame extends JFrame {
    private Dimension screenSize;
    private Dimension mainFrameSize;
    private Point mainFrameLocation ;
    private JTabbedPane bookTabbedPane;
    public static String defaultUrlWithSpaces;

    public MainFrame(String name) {
        super(name);
        setFrameParameters();
    }

    public void setEverything() {
        /*Test testForTable = new Test();
        testForTable.testTable(this);*/

        BookTable bookTable = getDefaultBookTable();

        bookTabbedPane = new JTabbedPane();
        bookTabbedPane.add("default table", new JScrollPane(bookTable));
        bookTabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        BookMenuBar bookMenuBar = new BookMenuBar(this, bookTabbedPane);
        setJMenuBar(bookMenuBar);

        add(bookTabbedPane);

        BookButtonPanel bookButtonPanel = new BookButtonPanel(bookTabbedPane);
        add(bookButtonPanel, BorderLayout.EAST);

        add(new JTextArea("1) The table is saved automatically. Just add or insert record and close.\n" +
                          "2) The remove button removes selected row or the last one if no row is selected.\n" +
                          "3) The File option in the menu bar is a demo version. It doesn't have much functionality."),
                BorderLayout.SOUTH);

        saveDefaultBookTableIfChanged();
    }

    private BookTable getDefaultBookTable() {
        URL defaultUrl = getClass().getClassLoader().getResource("resources/defaultTable/default table.ser");
        //System.out.println(url);
        //String filePath = new File("").getAbsolutePath();
        defaultUrlWithSpaces = defaultUrl.getPath().replaceAll("%20"," ");
        BookTableFileDeserializer deserializer = new BookTableFileDeserializer(new File(defaultUrlWithSpaces));
        deserializer.open();
        return deserializer.getBookTable();
    }

    private void setFrameParameters() {
        screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        mainFrameSize = new Dimension(screenSize.width/2,screenSize.height/2);
        mainFrameLocation = new Point((screenSize.width - mainFrameSize.width)/2, (screenSize.height - mainFrameSize.height)/2);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(mainFrameSize);
        setLocation(mainFrameLocation );

        setVisible(true);
    }

    public JTabbedPane getBookTabbedPane() {
        return bookTabbedPane;
    }

    private void saveDefaultBookTableIfChanged() {
        int indexOfDefaultTab = 0;
        JScrollPane selectedTab = (JScrollPane)bookTabbedPane.getComponent(indexOfDefaultTab);
        JViewport viewport = selectedTab.getViewport();
        BookTable selectedBookTable = (BookTable)viewport.getView();

        validateBookTable(selectedBookTable, indexOfDefaultTab);
    }

    private void validateBookTable(BookTable selectedBookTable, int indexOfSelectedTab) {
        TableModel bookTableModel = selectedBookTable.getModel();
        bookTableModel.addTableModelListener(new BookTableModelListener(selectedBookTable, indexOfSelectedTab));
    }
}
