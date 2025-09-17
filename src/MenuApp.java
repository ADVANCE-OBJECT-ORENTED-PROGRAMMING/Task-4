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

        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
