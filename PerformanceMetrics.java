import java.awt.GridLayout;
import javax.swing.*;

public class PerformanceMetrics extends JFrame {
    private JLabel resultLabel;

    public PerformanceMetrics(Athlete[] athletes) {
        setTitle("Performance Metrics");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JButton calculateButton = new JButton("Calculate Average Performance");
        resultLabel = new JLabel();

        calculateButton.addActionListener(e -> {
            double averagePerformance = calculateAveragePerformance(athletes);
            resultLabel.setText("Average Performance: " + averagePerformance);
        });

        add(calculateButton);
        add(resultLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public double calculateAveragePerformance(Athlete[] athletes) {
        double totalPerformance = 0;
        for (Athlete athlete : athletes) {
            totalPerformance += athlete.getPerformance();
        }
        return totalPerformance / athletes.length;
    }
}
