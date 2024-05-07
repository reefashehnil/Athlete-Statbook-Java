import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataEntry extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField statisticsField;
    private JTextField achievementsField;
    private JTextField heightField;
    private JTextField weightField;
    private JTextField dobField;
    private JTextField contactInfoField;
    private JTextField performanceField;

    public DataEntry() {
        setTitle("Athlete Statbook - Data Entry");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(10, 2)); // Changed to accommodate additional fields

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel statisticsLabel = new JLabel("Statistics:");
        statisticsField = new JTextField();
        JLabel achievementsLabel = new JLabel("Achievements:");
        achievementsField = new JTextField();
        JLabel heightLabel = new JLabel("Height (cm):"); // Added height label
        heightField = new JTextField(); // Added height field
        JLabel weightLabel = new JLabel("Weight (kg):"); // Added weight label
        weightField = new JTextField(); // Added weight field
        JLabel dobLabel = new JLabel("Date of Birth:"); // Added DOB label
        dobField = new JTextField(); // Added DOB field
        JLabel contactInfoLabel = new JLabel("Contact Info:"); // Added contact info label
        contactInfoField = new JTextField(); // Added contact info field
        JLabel performanceLabel = new JLabel("Performance:");
        performanceField = new JTextField();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());
                String dob = dobField.getText();
                String contactInfo = contactInfoField.getText();
                String statistics = statisticsField.getText();
                String achievements = achievementsField.getText();
                double performance = Double.parseDouble(performanceField.getText());

                Athlete athlete = new Athlete(name, age, height, weight, dob, contactInfo, statistics, achievements, performance);

                saveAthleteData(athlete);

                JOptionPane.showMessageDialog(null, "Athlete data saved successfully.");
            }
        });

        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(statisticsLabel);
        add(statisticsField);
        add(achievementsLabel);
        add(achievementsField);
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(dobLabel);
        add(dobField);
        add(contactInfoLabel);
        add(contactInfoField);
        add(performanceLabel);
        add(performanceField);
        add(saveButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void saveAthleteData(Athlete athlete) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("athlete_data.txt", true));
            writer.write(athlete.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new DataEntry();
    }
}
