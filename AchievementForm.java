// AchievementForm.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AchievementForm extends JFrame {
    private JTextField nameField;
    private JTextField dateField;
    private JTextField descriptionField;

    public AchievementForm() {
        setTitle("Add Achievement");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel dateLabel = new JLabel("Date:");
        dateField = new JTextField();
        JLabel descriptionLabel = new JLabel("Description:");
        descriptionField = new JTextField();

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String date = dateField.getText();
                String description = descriptionField.getText();

                Achievement achievement = new Achievement(name, date, description);
                saveAchievementData(achievement);

                JOptionPane.showMessageDialog(null, "Achievement saved successfully.");
            }
        });

        add(nameLabel);
        add(nameField);
        add(dateLabel);
        add(dateField);
        add(descriptionLabel);
        add(descriptionField);
        add(saveButton);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void saveAchievementData(Achievement achievement) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("achievement_data.txt", true));
            writer.write(achievement.toString());
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

