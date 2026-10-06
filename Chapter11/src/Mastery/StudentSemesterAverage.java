package Mastery;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;

public class StudentSemesterAverage implements ActionListener {
    private JFrame frame;
    private JTextField nameField, levelField, semesterField;
    private JTextField[] gradeFields = new JTextField[4];

    private JLabel averageLabel;
    private JTextArea fileContents;
    private JButton saveButton, viewButton;

    private File studentFile = new File("students.txt");
    private DecimalFormat format = new DecimalFormat("0.#");

    public StudentSemesterAverage() {
        frame = new JFrame("Student Grade Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel fields = new JPanel(new GridLayout(7, 2, 3, 2));

        nameField = new JTextField();
        levelField = new JTextField();
        semesterField = new JTextField();

        fields.add(new JLabel("Student Name:"));
        fields.add(nameField);

        fields.add(new JLabel("Grade Level:"));
        fields.add(levelField);

        fields.add(new JLabel("Semester Number:"));
        fields.add(semesterField);

        for (int i = 0; i < gradeFields.length; i++) {
            gradeFields[i] = new JTextField();
            fields.add(new JLabel("Grade " + (i + 1) + ":"));
            fields.add(gradeFields[i]);
        }

        averageLabel = new JLabel("Average:");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(fields, BorderLayout.CENTER);
        topPanel.add(averageLabel, BorderLayout.SOUTH);
        frame.add(topPanel, BorderLayout.NORTH);

        fileContents = new JTextArea();
        fileContents.setEditable(false);

        frame.add(new JScrollPane(fileContents), BorderLayout.CENTER);

        saveButton = new JButton("Save to File");
        viewButton = new JButton("View File Contents");

        saveButton.addActionListener(this);
        viewButton.addActionListener(this);

        JPanel buttons = new JPanel();
        buttons.add(saveButton);
        buttons.add(viewButton);

        frame.add(buttons, BorderLayout.SOUTH);

        frame.setSize(675, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == saveButton) {
            saveToFile();
        } else if (event.getSource() == viewButton) {
            viewFileContents();
        }
    }

    private void saveToFile() {
        try {
            String name = nameField.getText().trim();

            if (name.isEmpty()) {
                showError("Please enter the student's name.");
                return;
            }

            int level = Integer.parseInt(levelField.getText().trim());
            int semester =
                Integer.parseInt(semesterField.getText().trim());

            if (level < 1 || level > 12
                    || semester < 1 || semester > 2) {
                showError(
                    "Grade level must be 1 to 12. Semester must be 1 or 2."
                );
                return;
            }

            double[] grades = new double[4];
            double total = 0;

            for (int i = 0; i < grades.length; i++) {
                grades[i] =
                    Double.parseDouble(gradeFields[i].getText().trim());

                if (Double.isNaN(grades[i])
                        || Double.isInfinite(grades[i])
                        || grades[i] < 0 || grades[i] > 100) {
                    showError(
                        "Each grade must be a number from 0 to 100."
                    );
                    return;
                }

                total += grades[i];
            }

            double average = total / grades.length;

            String record =
                "Name: " + name
                + ", Grade Level: " + level
                + ", Semester: " + semester
                + ", Grades: " + grades[0]
                + ", " + grades[1]
                + ", " + grades[2]
                + ", " + grades[3]
                + ", Average: " + format.format(average) + "%";

            // true appends new records without removing earlier records.
            try (BufferedWriter writer =
                    new BufferedWriter(
                        new FileWriter(studentFile, true))) {
                writer.write(record);
                writer.newLine();
            }

            averageLabel.setText(
                "Average: " + format.format(average) + "%"
            );

            JOptionPane.showMessageDialog(
                frame, "Data saved successfully!"
            );

        } catch (NumberFormatException e) {
            showError(
                "Enter whole numbers for grade level and semester, "
                + "and numbers for all grades."
            );
        } catch (IOException e) {
            showError("Unable to save the file: " + e.getMessage());
        } catch (SecurityException e) {
            showError("You do not have permission to save this file.");
        }
    }

    private void viewFileContents() {
        try (BufferedReader reader =
                new BufferedReader(new FileReader(studentFile))) {

            StringBuilder contents = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                contents.append(line).append("\n");
            }

            fileContents.setText(contents.toString());
            fileContents.setCaretPosition(0);

            if (contents.length() == 0) {
                JOptionPane.showMessageDialog(
                    frame, "The file is empty."
                );
            }

        } catch (FileNotFoundException e) {
            showError(
                "No saved file was found. Save a student record first."
            );
        } catch (IOException e) {
            showError("Unable to read the file: " + e.getMessage());
        } catch (SecurityException e) {
            showError("You do not have permission to read this file.");
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(
            frame, message, "Error", JOptionPane.ERROR_MESSAGE
        );
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentSemesterAverage();
            }
        });
    }
}