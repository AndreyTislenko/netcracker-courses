package gui.bookMenuBar;

import bookTableFile.bookTableFileDeserializer.BookTableFileDeserializer;
import bookTableFile.bookTableFileSerializer.BookTableFileSerializer;
import gui.bookMainFrame.MainFrame;
import gui.bookMenuBar.bookTableDialog.BookTableDialog;
import gui.bookTable.BookTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class BookMenuBar extends JMenuBar{
    private JTabbedPane bookTabbedPane;
    private MainFrame mainFrame;
    private JFileChooser fileChooser;

    public BookMenuBar(MainFrame mainFrame, JTabbedPane bookTabbedPane){
        this.mainFrame = mainFrame;
        this.bookTabbedPane = bookTabbedPane;
        createMenuBar();
        fileChooser = new JFileChooser();
    }

    private void createMenuBar() {
        //some icons just in case
        var iconNew = new ImageIcon("src/resources/new.png");
        var iconOpen = new ImageIcon("src/resources/open.png");
        var iconSave = new ImageIcon("src/resources/save.png");
        var iconExit = new ImageIcon("src/resources/exit.png");

        var fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        var newMenuItem = new JMenuItem(new MenuItemAction("New", iconNew, KeyEvent.VK_N));

        var openMenuItem = new JMenuItem(new MenuItemAction("Open", iconOpen, KeyEvent.VK_O));

        var saveMenuItem = new JMenuItem(new MenuItemAction("Save", iconSave, KeyEvent.VK_S));

        var exitMenuItem = new JMenuItem("Exit", iconExit);
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
        exitMenuItem.addActionListener((event) -> System.exit(0));

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        add(fileMenu);
    }

    private class MenuItemAction extends AbstractAction {
        public MenuItemAction(String text, ImageIcon icon, Integer mnemonic) {
            super(text);
            putValue(SMALL_ICON, icon);
            putValue(MNEMONIC_KEY, mnemonic);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JMenuItem menuItem = (JMenuItem)e.getSource();

            String stringMenuItem = menuItem.getText();

            if(stringMenuItem.equals("New")) {
                BookTableDialog newTableDialog = new BookTableDialog(mainFrame);
                newTableDialog.createPopupFrameFor(bookTabbedPane);
            } else if(stringMenuItem.equals("Save")) {
                int returnValue = fileChooser.showSaveDialog(BookMenuBar.this);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    JScrollPane selectedTab = (JScrollPane)bookTabbedPane.getSelectedComponent();
                    JViewport viewport = selectedTab.getViewport();
                    BookTable selectedBookTable = (BookTable)viewport.getView();

                    BookTableFileSerializer serializer = new BookTableFileSerializer(file, selectedBookTable);
                    serializer.save();
                }
            } else if(stringMenuItem.equals("Open")) {
                int returnVal = fileChooser.showOpenDialog(BookMenuBar.this);

                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();

                    BookTableFileDeserializer deserializer = new BookTableFileDeserializer(file);
                    deserializer.open();
                    BookTable openedBookTable = deserializer.getBookTable();

                    mainFrame.getBookTabbedPane().add(file.getName(), new JScrollPane(openedBookTable));
                }
            }
            //System.out.println(e.getActionCommand());
        }

    }
}
