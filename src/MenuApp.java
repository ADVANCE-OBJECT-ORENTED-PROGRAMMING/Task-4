import javax.swing.*;
import java.awt.*;

public class MenuApp {
    JFrame frame;
    JPanel cardPanel;
    CardLayout cardLayout;
    MenuApp() {
        frame = new JFrame("Menu Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel homePanel = createPanel("Welcome to Home Page", Color.LIGHT_GRAY);
        JPanel profilePanel = createPanel("This is Profile Page", Color.RED);
        JPanel settingsPanel = createPanel("Settings Page", Color.GREEN);

        cardPanel.add(homePanel, "Home");
        cardPanel.add(profilePanel, "Profile");
        cardPanel.add(settingsPanel, "Settings");


        frame.add(cardPanel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private JPanel createPanel(String text, Color bgColor) {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(bgColor);
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label);
        return panel;
    }
}
