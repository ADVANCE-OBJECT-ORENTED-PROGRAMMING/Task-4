import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuAppIntegrationTest {

    @Test
    void testInitialPanelIsHome() {
        MenuApp app = new MenuApp();
        assertEquals("Home", getCurrentCard(app));
    }

    @Test
    void testSwitchToProfilePanel() {
        MenuApp app = new MenuApp();
        app.cardLayout.show(app.cardPanel, "Profile");
        assertEquals("Profile", getCurrentCard(app));
    }

    @Test
    void testSwitchToSettingsPanel() {
        MenuApp app = new MenuApp();
        app.cardLayout.show(app.cardPanel, "Settings");
        assertEquals("Settings", getCurrentCard(app));
    }

    private String getCurrentCard(MenuApp app) {
        for (var comp : app.cardPanel.getComponents()) {
            if (comp.isVisible()) {
                if (comp.getBackground().equals(java.awt.Color.LIGHT_GRAY)) {
                    return "Home";
                } else if (comp.getBackground().equals(java.awt.Color.RED)) {
                    return "Profile";
                } else if (comp.getBackground().equals(java.awt.Color.GREEN)) {
                    return "Settings";
                }
            }
        }
        return null;
    }
}
