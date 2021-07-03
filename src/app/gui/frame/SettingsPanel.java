package app.gui.frame;

import app.gui.frame.tabs.AllFiguresPanel;
import app.gui.frame.tabs.AllGroupsPanel;

import javax.swing.*;
import java.awt.*;

public class SettingsPanel extends JPanel {
    private static final SettingsPanel instance = new SettingsPanel();

    private SettingsPanel() {
        this.setBackground(new Color(223, 223, 223));
        JPanel allFigures = new AllFiguresPanel();
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.add(allFigures, "All Shapes");
        JPanel allGroups = new AllGroupsPanel();
        tabbedPane.add(allGroups, "All Groups");
        this.add(tabbedPane);
    }

    public static SettingsPanel getInstance() {
        return instance;
    }
}
