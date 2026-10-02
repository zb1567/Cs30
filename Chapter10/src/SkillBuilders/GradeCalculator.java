package SkillBuilders;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class GradeCalculator {

    private JFrame frame;
    private Container contentPane;

    private JTextField grade1;
    private JTextField grade2;
    private JTextField grade3;

    private JButton avgButton;
    private JButton minButton;
    private JButton maxButton;

    private JLabel stat;

    public GradeCalculator() {

        frame = new JFrame("Grade Calculator");
        frame.setFont(new Font("Dialog", Font.PLAIN, 15));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = frame.getContentPane();
        contentPane.setLayout(new FlowLayout());

        // Create grade input fields
        contentPane.add(new JLabel("Grade 1:"));
        grade1 = new JTextField(5);
        contentPane.add(grade1);

        contentPane.add(new JLabel("Grade 2:"));
        grade2 = new JTextField(5);
        contentPane.add(grade2);

        contentPane.add(new JLabel("Grade 3:"));
        grade3 = new JTextField(5);
        contentPane.add(grade3);

        // Create Average button
        avgButton = new JButton("Average");
        avgButton.addActionListener(new AvgListener());
        contentPane.add(avgButton);

        // Create Min button
        minButton = new JButton("Min");
        minButton.setActionCommand("Min");
        minButton.addActionListener(new MinMaxListener());
        contentPane.add(minButton);

        // Create Max button
        maxButton = new JButton("Max");
        maxButton.setActionCommand("Max");
        maxButton.addActionListener(new MinMaxListener());
        contentPane.add(maxButton);

        // Create label to display statistics
        stat = new JLabel(" ");
        stat.setBorder(
            BorderFactory.createEmptyBorder(10, 0, 10, 0)
        );
        contentPane.add(stat);

        // Display the window
        frame.pack();
        frame.setVisible(true);
    }

    // Average button listener
    class AvgListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            double avgGrade;

            String g1 = grade1.getText();
            String g2 = grade2.getText();
            String g3 = grade3.getText();

            avgGrade = (
                Double.parseDouble(g1)
                + Double.parseDouble(g2)
                + Double.parseDouble(g3)
            ) / 3;

            stat.setText("Average: " + Double.toString(avgGrade));
        }
    }

    // Min and Max button listener
    class MinMaxListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            double g1 = Double.parseDouble(grade1.getText());
            double g2 = Double.parseDouble(grade2.getText());
            double g3 = Double.parseDouble(grade3.getText());

            double result;

            if (event.getActionCommand().equals("Min")) {

                result = Math.min(g1, Math.min(g2, g3));
                stat.setText("Minimum: " + Double.toString(result));

            } else if (event.getActionCommand().equals("Max")) {

                result = Math.max(g1, Math.max(g2, g3));
                stat.setText("Maximum: " + Double.toString(result));
                   
                DecimalFormat dc = new DecimalFormat("0.0");
                	
                
              
              + dc.format(avgGrade));
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        new GradeCalculator();
    }
}