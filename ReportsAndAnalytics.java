import javax.swing.*;
import java.awt.*;

public class ReportsAndAnalytics extends JFrame {
    public ReportsAndAnalytics() {
        setTitle("Reports and Analytics");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // Create some dummy content for the reports
        JTextArea reportsArea = new JTextArea();
        reportsArea.setText("Report 1:\n - Data 1\n - Data 2\n\nReport 2:\n - Data A\n - Data B");
        reportsArea.setEditable(false);
        
        // Create a scroll pane to hold the reports
        JScrollPane scrollPane = new JScrollPane(reportsArea);
        
        // Add the scroll pane to the frame
        add(scrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ReportsAndAnalytics();
    }
}
