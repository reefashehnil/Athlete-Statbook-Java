import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class DataModification extends JFrame implements ActionListener {
    private JTextField searchField;
    private JTextField nameField;
    private JTextField ageField;
    private JTextField heightField;
    private JTextField weightField;
    private JTextField dobField;
    private JTextField contactInfoField;
    private JTextField statisticsField;
    private JTextField achievementsField;
    private JTextField performanceField;

    private JTextArea resultArea;
    private Athlete[] athletes;

    public DataModification(Athlete[] athletes) {
        this.athletes = athletes;

        setTitle("Athlete Statbook - Data Modification");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel searchPanel = new JPanel(new FlowLayout());
        JLabel searchLabel = new JLabel("Search Athlete:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(this);

        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        JPanel modificationPanel = new JPanel(new GridLayout(9, 2));
        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel ageLabel = new JLabel("Age:");
        ageField = new JTextField();
        JLabel heightLabel = new JLabel("Height (cm):");
        heightField = new JTextField();
        JLabel weightLabel = new JLabel("Weight (kg):");
        weightField = new JTextField();
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobField = new JTextField();
        JLabel contactInfoLabel = new JLabel("Contact Info:");
        contactInfoField = new JTextField();
        JLabel statisticsLabel = new JLabel("Statistics:");
        statisticsField = new JTextField();
        JLabel achievementsLabel = new JLabel("Achievements:");
        achievementsField = new JTextField();
        JLabel performanceLabel = new JLabel("Performance:");
        performanceField = new JTextField();
        modificationPanel.add(nameLabel);
        modificationPanel.add(nameField);
        modificationPanel.add(ageLabel);
        modificationPanel.add(ageField);
        modificationPanel.add(heightLabel);
        modificationPanel.add(heightField);
        modificationPanel.add(weightLabel);
        modificationPanel.add(weightField);
        modificationPanel.add(dobLabel);
        modificationPanel.add(dobField);
        modificationPanel.add(contactInfoLabel);
        modificationPanel.add(contactInfoField);
        modificationPanel.add(statisticsLabel);
        modificationPanel.add(statisticsField);
        modificationPanel.add(achievementsLabel);
        modificationPanel.add(achievementsField);
        modificationPanel.add(performanceLabel);
        modificationPanel.add(performanceField);
        JButton saveButton = new JButton("Save Changes");
        saveButton.addActionListener(this);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(searchPanel, BorderLayout.NORTH);
        add(modificationPanel, BorderLayout.CENTER);
        add(saveButton, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private String searchAthlete(String searchTerm) {
        StringBuilder result = new StringBuilder();
        for (Athlete athlete : athletes) {
            if (athlete.getName().equalsIgnoreCase(searchTerm)) {
                result.append(athlete.toString()).append("\n");
            }
        }
        return result.length() > 0 ? result.toString() : "Athlete not found.";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {
            String searchTerm = searchField.getText();
            String athleteInfo = searchAthlete(searchTerm);
            resultArea.setText(athleteInfo);
        } else if (e.getActionCommand().equals("Save Changes")) {
            String searchTerm = searchField.getText();

            for (Athlete athlete : athletes) {
                if (athlete.getName().equalsIgnoreCase(searchTerm)) {
                    athlete.setName(nameField.getText());
                    athlete.setAge(Integer.parseInt(ageField.getText()));
                    athlete.setHeight(Double.parseDouble(heightField.getText()));
                    athlete.setWeight(Double.parseDouble(weightField.getText()));
                    athlete.setDOB(dobField.getText());
                    athlete.setContactInfo(contactInfoField.getText());
                    athlete.setStatistics(statisticsField.getText());
                    athlete.setAchievements(achievementsField.getText());
                    athlete.setPerformance(Double.parseDouble(performanceField.getText()));
                    saveAthleteData(athletes);
                    resultArea.setText("Changes saved successfully.");
                    return;
                }
            }
            resultArea.setText("Athlete not found.");
        }
    }

    private void saveAthleteData(Athlete[] athletes) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("athlete_data.txt"));
            for (Athlete athlete : athletes) {
                writer.write(athlete.toString());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
   }
}