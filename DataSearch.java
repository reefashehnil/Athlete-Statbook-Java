import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataSearch extends JFrame implements ActionListener {
    private JTextField searchField;
    private JTextArea resultArea;
    private Athlete[] athletes;

    public DataSearch(Athlete[] athletes) {
        this.athletes = athletes;

        setTitle("Athlete Statbook - Data Search");
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

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        add(searchPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

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
        String searchTerm = searchField.getText();
        String athleteInfo = searchAthlete(searchTerm);
        resultArea.setText(athleteInfo);
    }

}
