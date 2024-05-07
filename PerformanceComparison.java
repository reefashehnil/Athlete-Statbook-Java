import java.awt.GridLayout;
import javax.swing.*;

public class PerformanceComparison extends JFrame {
    private JLabel resultLabel;

    public PerformanceComparison(Athlete[] athletes) {
        setTitle("Performance Comparison");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(2, 1));

        JButton compareButton = new JButton("Compare Performance");
        resultLabel = new JLabel();

        compareButton.addActionListener(e -> {
            Athlete bestAthlete = compareByPerformance(athletes);
            resultLabel.setText("Best Athlete: " + bestAthlete.getName());
        });

        add(compareButton);
        add(resultLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static Athlete compareByPerformance(Athlete[] athletes) {
        Athlete bestAthlete = null;
        double bestPerformance = Double.MIN_VALUE;

        for (Athlete athlete : athletes) {
            if (athlete.getPerformance() > bestPerformance) {
                bestPerformance = athlete.getPerformance();
                bestAthlete = athlete;
            }
        }

        return bestAthlete;
    }
}
