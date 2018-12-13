package gui.bookMenuBar.bookTableDialog;

import gui.bookMainFrame.MainFrame;
import gui.bookTable.BookTable;
import gui.bookTable.bookTableModelListener.BookTableModelListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class BookTableDialog extends JDialog{
    private MainFrame mainFrame;
    private JTabbedPane bookTabbedPane;
    private JPanel okCancelButtonPanelContainer;
    private JPanel inputAndLabelsContainer;

    public BookTableDialog(MainFrame mainFrame) {
        super(mainFrame, "new table config");
        this.mainFrame = mainFrame;
    }

    public void createPopupFrameFor(JTabbedPane bookTabbedPane){
        this.bookTabbedPane = bookTabbedPane;

        setInputAndLabelsContainer();
        add(inputAndLabelsContainer, BorderLayout.NORTH);

        setOkCancelButtonPanelContainer();
        add(okCancelButtonPanelContainer, BorderLayout.SOUTH);

        setBookTableDialogParameters();
    }

    private void setInputAndLabelsContainer() {
        JPanel inputAndLabels = new JPanel(new GridLayout(3,2,20,20));
        inputAndLabels.add(new JLabel("Table's name:"));
        JPanel nameAndErrorPanel = new JPanel();
        nameAndErrorPanel.setLayout(new BoxLayout(nameAndErrorPanel, BoxLayout.Y_AXIS));
        nameAndErrorPanel.add(new JTextField(10));
        //label for error
        nameAndErrorPanel.add(new JLabel());

        inputAndLabels.add(nameAndErrorPanel);

        inputAndLabels.add(new JLabel("Initial amount of rows:"));
        JPanel numberAndErrorPanel = new JPanel();
        numberAndErrorPanel.setLayout(new BoxLayout(numberAndErrorPanel, BoxLayout.Y_AXIS));
        numberAndErrorPanel.add(new JTextField(10));
        //label for error
        numberAndErrorPanel.add(new JLabel());

        inputAndLabels.add(numberAndErrorPanel);

        inputAndLabelsContainer = new JPanel(new BorderLayout());
        inputAndLabelsContainer.add(inputAndLabels);
    }

    private void setOkCancelButtonPanelContainer() {
        JButton okButton = new JButton("create");
        okButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel inputAndLabels = (JPanel)inputAndLabelsContainer.getComponent(0);

                JPanel numberAndErrorPanel = (JPanel)inputAndLabels.getComponent(3);
                JTextField textFieldNumber = (JTextField)numberAndErrorPanel.getComponent(0);
                int numberOfRows = 1;
                try {
                    numberOfRows = Integer.parseInt(textFieldNumber.getText());
                    if(numberOfRows < 0) throw new NumberFormatException();
                } catch (NumberFormatException exc) {
                    JLabel errorNumberMessage = (JLabel)numberAndErrorPanel.getComponent(1);
                    errorNumberMessage.setText("Enter a positive number please");
                    errorNumberMessage.setForeground(Color.RED);
                    pack();
                    return;
                }

                BookTable bookTable = new BookTable(numberOfRows);

                JPanel nameAndErrorPanel = (JPanel)inputAndLabels.getComponent(1);
                JTextField textFieldName = (JTextField)nameAndErrorPanel.getComponent(0);
                if(textFieldName.getText().isEmpty()) {
                    JLabel errorNameMessage = (JLabel)nameAndErrorPanel.getComponent(1);
                    errorNameMessage.setText("The name shouldn't be blank");
                    errorNameMessage.setForeground(Color.RED);
                    pack();
                    return;
                }

                String tableName = textFieldName.getText();
                bookTabbedPane.add(tableName, new JScrollPane(bookTable));

                bookTable.getModel().addTableModelListener(new BookTableModelListener(bookTable, bookTabbedPane.getTabCount() - 1));

                setVisible(false);
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        JPanel okCancelButtonPanel = new JPanel(new GridLayout(1,2,5,0));
        okCancelButtonPanel.add(okButton);
        okCancelButtonPanel.add(cancelButton);
        okCancelButtonPanelContainer = new JPanel();
        okCancelButtonPanelContainer.add(okCancelButtonPanel);
    }

    private void setBookTableDialogParameters() {
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        pack();

        Point centerPoint = new Point(mainFrame.getLocation().x + (mainFrame.getWidth() - getWidth())/2,
                mainFrame.getLocation().y + (mainFrame.getHeight() - getHeight())/2);

        setLocation(centerPoint);
        setVisible(true);
    }
}
