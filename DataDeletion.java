
import static java.awt.AWTEventMulticaster.add;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class DataDeletion extends JFrame implements ActionListener {
    private JTextField searchField;
    private JTextArea resultArea;
    private Athlete[] athletes;

    public DataDeletion(Athlete[] athletes) {
        this.athletes = athletes;

        setTitle("Athlete Statbook - Data Deletion");
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

        JButton deleteButton = new JButton("Delete Athlete");
        deleteButton.addActionListener(this);

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(searchPanel, BorderLayout.NORTH);
        add(deleteButton, BorderLayout.CENTER);
        add(new JScrollPane(resultArea), BorderLayout.SOUTH);

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

    private void deleteAthlete(String searchTerm) {
        for (int i = 0; i < athletes.length; i++) {
            if (athletes[i].getName().equalsIgnoreCase(searchTerm)) {
                athletes[i] = null;
                // Shift remaining elements to remove null
                for (int j = i; j < athletes.length - 1; j++) {
                    athletes[j] = athletes[j + 1];
                }
                athletes[athletes.length - 1] = null;
                saveAthleteData(athletes);
                resultArea.setText("Athlete deleted successfully.");
                return;
            }
        }
        resultArea.setText("Athlete not found.");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {
            String searchTerm = searchField.getText();
            String athleteInfo = searchAthlete(searchTerm);
            resultArea.setText(athleteInfo);
        } else if (e.getActionCommand().equals("Delete Athlete")) {
            String searchTerm = searchField.getText();
            deleteAthlete(searchTerm);
        }
    }

    private void saveAthleteData(Athlete[] athletes) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("athlete_data.txt"));
            for (Athlete athlete : athletes) {
                if (athlete != null) {
                    writer.write(athlete.toString());
                    writer.newLine();
                }
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
