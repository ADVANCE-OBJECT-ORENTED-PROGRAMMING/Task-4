import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class MenuAppTest {
    private MenuApp menuApp;

    @BeforeEach
    void setUp() {
        SwingUtilities.invokeLater(() -> menuApp = new MenuApp());
        try {
            // Wait for EDT to build UI
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFrameInitialization() {
        assertNotNull(menuApp.frame);
        assertEquals("Menu Example", menuApp.frame.getTitle());
        assertTrue(menuApp.frame.isVisible());
    }

    @Test
    void testMenuBarExists() {
        JMenuBar menuBar = menuApp.frame.getJMenuBar();
        assertNotNull(menuBar);
        assertEquals(3, menuBar.getMenuCount());

        JMenu fileMenu = menuBar.getMenu(0);
        JMenu viewMenu = menuBar.getMenu(1);
        JMenu helpMenu = menuBar.getMenu(2);

        assertEquals("File", fileMenu.getText());
        assertEquals("View", viewMenu.getText());
        assertEquals("Help", helpMenu.getText());
    }

    @Test
    void testPanelSwitching() {
        // Simulate switching panels manually
        SwingUtilities.invokeLater(() -> {
            menuApp.cardLayout.show(menuApp.cardPanel, "Profile");

            JPanel currentPanel = (JPanel) menuApp.cardPanel.getComponents()[1];
            assertEquals(Color.RED, currentPanel.getBackground());
        });
    }

    @Test
    void testAboutDialog() {
        // This is harder to unit test directly. You could mock JOptionPane if using a mocking framework.
        // For now, we ensure the menu exists and has 1 item
        JMenu helpMenu = menuApp.frame.getJMenuBar().getMenu(2);
        assertEquals("Help", helpMenu.getText());
        assertEquals(1, helpMenu.getItemCount());
        assertEquals("About", helpMenu.getItem(0).getText());
    }
}
