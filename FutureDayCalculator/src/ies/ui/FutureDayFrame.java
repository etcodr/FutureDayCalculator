package ies.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FutureDayFrame extends JFrame {

    private final DateTimeFormatter DT = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField daysOutField;
    private JTextField totalDaysField;
    private JTextField weekendDaysField;
    private JRadioButton rdoButton1;
    private JRadioButton rdoButton2;

    public FutureDayFrame() {
        initComponents();
    }

    private void initComponents() {
        try {
            UIManager.setLookAndFeel(
                UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }

        setTitle("Future Day Calculator");
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);

        LocalDate currentDate = LocalDate.now();

        startDateField = new JTextField(currentDate.format(DT));
        endDateField = new JTextField();
        daysOutField = new JTextField();
        totalDaysField = new JTextField();
        weekendDaysField = new JTextField();
        rdoButton1 = new JRadioButton("Weekdays");
        rdoButton2 = new JRadioButton("Days");

        totalDaysField.setEditable(false);
        weekendDaysField.setEditable(false);

        rdoButton1.setSelected(true);

        Dimension dim = new Dimension(150, 20);
        startDateField.setPreferredSize(dim);
        endDateField.setPreferredSize(dim);
        daysOutField.setPreferredSize(dim);
        totalDaysField.setPreferredSize(dim);
        weekendDaysField.setPreferredSize(dim);
        startDateField.setMinimumSize(dim);
        endDateField.setMinimumSize(dim);
        daysOutField.setMinimumSize(dim);
        totalDaysField.setMinimumSize(dim);
        weekendDaysField.setMinimumSize(dim);

        JButton calculateButton = new JButton("Calculate");
        JButton exitButton = new JButton("Exit");

        calculateButton.addActionListener(e -> calculateButtonClicked());
        exitButton.addActionListener(e -> exitButtonClicked());

        // toggle group
        ButtonGroup radioPanel = new ButtonGroup();
        radioPanel.add(rdoButton1);
        radioPanel.add(rdoButton2);
        Box rdoButtonBox = Box.createHorizontalBox();
        rdoButtonBox.add(rdoButton1);
        rdoButtonBox.add(rdoButton2);

        // button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(calculateButton);
        buttonPanel.add(exitButton);

        // main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(new JLabel("Start date:"), getConstraints(0, 0));
        panel.add(startDateField, getConstraints(1, 0));
        panel.add(new JLabel("End date:"), getConstraints(0, 1));
        panel.add(endDateField, getConstraints(1, 1));
        panel.add(new JLabel("Days out:"), getConstraints(0, 2));
        panel.add(daysOutField, getConstraints(1, 2));
        panel.add(new JLabel("Total days:"), getConstraints(0, 3));
        panel.add(totalDaysField, getConstraints(1, 3));
        panel.add(new JLabel("Weekend days:"), getConstraints(0, 4));
        panel.add(weekendDaysField, getConstraints(1, 4));

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(10, 5, 0, 5);
        c.gridx = 1;
        c.gridwidth = 2;
        c.gridy = 5;
        panel.add(rdoButtonBox, c);

        add(panel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(new Dimension(300, 300));
        // setVisible(true);
    }

    // helper method for getting a GridBagConstraints object
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }

    private void calculateButtonClicked() {
        // TODO add validation for user input
        // TODO invoke the calculateFutureDay method depending on the toggle button selection
    }

    private void exitButtonClicked() { System.exit(0); }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new FutureDayFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
