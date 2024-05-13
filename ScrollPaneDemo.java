import javax.swing.*;
import java.awt.*;

public class ScrollPaneDemo {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create JFrame
            JFrame frame = new JFrame("Scroll Pane Demo");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            // Create JPanel with GridLayout for the initial 9 labels
            JPanel gridPanel = new JPanel(new GridLayout(0, 3));

            // Add 10 JLabels to the panel
            for (int i = 0; i < 10; i++) {
                JLabel label = new JLabel("Item " + (i + 1));
                gridPanel.add(label);
            }

            // Create JPanel with BorderLayout
            JPanel mainPanel = new JPanel(new BorderLayout());

            // Add the gridPanel to the top part of the BorderLayout
            mainPanel.add(gridPanel, BorderLayout.NORTH);

            // Create JScrollPane and add the main panel to it
            JScrollPane scrollPane = new JScrollPane(mainPanel);

            // Add JScrollPane to the JFrame
            frame.add(scrollPane);

            // Display the JFrame
            frame.setVisible(true);
        });
    }
}
