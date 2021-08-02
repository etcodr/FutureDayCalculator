package ies.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
    }
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            JFrame frame = new FutureDayFrame();
        });
    }
}
