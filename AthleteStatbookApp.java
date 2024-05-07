import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AthleteStatbookApp extends JFrame implements ActionListener {
    private Athlete[] athletes;
    private JTextArea outputArea;
    private boolean loggedIn = false;
    private String loggedInUser;

    public AthleteStatbookApp(Athlete[] athletes) {
        this.athletes = athletes;

        setTitle("Athlete Statbook");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create buttons for different functionalities
        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");
        JButton dataEntryButton = new JButton("Data Entry");
        JButton dataViewingButton = new JButton("Data Viewing");
        JButton dataSearchButton = new JButton("Data Search");
        JButton dataModificationButton = new JButton("Data Modification");
        JButton dataDeletionButton = new JButton("Data Deletion");
        JButton performanceMetricsButton = new JButton("Performance Metrics");
        JButton achievementButton = new JButton("Achievement");
        JButton performanceComparisonButton = new JButton("Performance Comparison");
        JButton reportsButton = new JButton("Reports and Analytics");
        JButton exitButton = new JButton("Exit");
        // Add action listeners for the buttons
        loginButton.addActionListener(this);
        registerButton.addActionListener(this);
        dataEntryButton.addActionListener(this);
        dataViewingButton.addActionListener(this);
        dataSearchButton.addActionListener(this);
        dataModificationButton.addActionListener(this);
        dataDeletionButton.addActionListener(this);
        performanceMetricsButton.addActionListener(this);
        achievementButton.addActionListener(this);
        performanceComparisonButton.addActionListener(this);
        reportsButton.addActionListener(this);
        exitButton.addActionListener(this);
        // Add buttons to the main window
        JPanel loginPanel = new JPanel(new GridLayout(2, 2));
        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();
        loginPanel.add(dataEntryButton);
        loginPanel.add(dataViewingButton);
        loginPanel.add(dataSearchButton);
        loginPanel.add(dataModificationButton);
        loginPanel.add(dataDeletionButton);
        loginPanel.add(performanceMetricsButton);
        loginPanel.add(achievementButton);
        loginPanel.add(performanceComparisonButton);
        loginPanel.add(reportsButton);
        loginPanel.add(exitButton);
        loginPanel.add(usernameLabel);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(loginButton);
        buttonPanel.add(registerButton);

        add(loginPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!loggedIn) {
            String username = JOptionPane.showInputDialog("Enter username:");
            String password = JOptionPane.showInputDialog("Enter password:");

            if (UserAuthentication.authenticateUser(username, password)) {
                loggedIn = true;
                loggedInUser = username;
                outputArea.setText("Logged in as: " + username);

                // Enable functionality buttons after successful login
                enableFunctionalityButtons(true);
            } else {
                outputArea.setText("Invalid username or password.");
            }
            
        } else {
             if (e.getActionCommand().equals("Register")) {
             String username = JOptionPane.showInputDialog("Enter username:");
             String password = JOptionPane.showInputDialog("Enter password:");
             if (username != null && password != null) {
             UserData.registerUser(username, password);
             outputArea.setText("User registered successfully.");
        } else {
             outputArea.setText("Invalid input. Please try again.");
    }
}
             else if (e.getActionCommand().equals("Data Entry")) {
                DataEntry dataEntry = new DataEntry();
                dataEntry.setVisible(true);
            } else if (e.getActionCommand().equals("Data Viewing")) {
                DataViewing dataViewing = new DataViewing();
                dataViewing.setVisible(true);
            } else if (e.getActionCommand().equals("Data Search")) {
                DataSearch dataSearch = new DataSearch(athletes);
                dataSearch.setVisible(true);
            } else if (e.getActionCommand().equals("Data Modification")) {
                DataModification dataModification = new DataModification(athletes);
                dataModification.setVisible(true);
            } else if (e.getActionCommand().equals("Data Deletion")) {
                DataDeletion dataDeletion = new DataDeletion(athletes);
                dataDeletion.setVisible(true);
            } else if (e.getActionCommand().equals("Performance Metrics")) {
                String metrics = calculateMetrics();
                outputArea.setText(metrics);
            } else if (e.getActionCommand().equals("Achievement")) {
                String achievements = showAchievements();
                outputArea.setText(achievements);
            } else if (e.getActionCommand().equals("Performance Comparison")) {
                String comparisonResult = comparePerformances();
                outputArea.setText(comparisonResult);
            } else if (e.getActionCommand().equals("Reports and Analytics")) {
                String report = generateReport();
                outputArea.setText(report);
            } else if (e.getActionCommand().equals("Exit")) {
                ExitOption.exitProgram();
            }
        }
    }

    // Enable or disable functionality buttons
    private void enableFunctionalityButtons(boolean enable) {
        Component[] components = getContentPane().getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                component.setEnabled(enable);
            }
        }
    }

    private String calculateMetrics() {
        // Implement Performance Metrics logic here
        return "Performance Metrics:\n- Metric 1: ...\n- Metric 2: ...";
    }

    private String showAchievements() {
        // Implement Achievement logic here
        return "Achievements:\n- Achievement 1: ...\n- Achievement 2: ...";
    }

    private String comparePerformances() {
        // Implement Performance Comparison logic here
        return "Performance Comparison Result:\n- Comparison 1: ...\n- Comparison 2: ...";
    }

    private String generateReport() {
        // Implement Reports and Analytics logic here
        return "Report:\n- Report Section 1: ...\n- Report Section 2: ...";
    }

    public static void main(String[] args) {
        Athlete[] athletes = {
                            new Athlete("John Doe", 25, 180.0, 75.0, "1998-05-15", "john.doe@example.com", "Some statistics", "Some achievements",1500.50)
        };

        SwingUtilities.invokeLater(() -> {
            AthleteStatbookApp app = new AthleteStatbookApp(athletes);
            app.setVisible(true);
        });
    }
}
