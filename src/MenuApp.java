import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

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

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);

        JMenu viewMenu = new JMenu("View");
        JMenuItem homeItem = new JMenuItem("Home");
        JMenuItem profileItem = new JMenuItem("Profile");
        JMenuItem settingsItem = new JMenuItem("Settings");

        homeItem.addActionListener(e -> cardLayout.show(cardPanel, "Home"));
        profileItem.addActionListener(e -> cardLayout.show(cardPanel, "Profile"));
        settingsItem.addActionListener(e -> cardLayout.show(cardPanel, "Settings"));

        viewMenu.add(homeItem);
        viewMenu.add(profileItem);
        viewMenu.add(settingsItem);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem(new AbstractAction("About") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "Swing Application Example\nCreated by Logical Building Guys!",
                        "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        frame.setJMenuBar(menuBar);
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
