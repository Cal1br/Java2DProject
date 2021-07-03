package app.gui.frame;

import app.gui.listeners.KeyListener;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        KeyListener.init();
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setTitle("GPI Project");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JMenuBar menuBar = new MenuBar();
        this.setJMenuBar(menuBar);
        JToolBar topToolBar = TopToolBar.getInstance();
        this.add(topToolBar, BorderLayout.PAGE_START);
        DrawPanel drawPanel = DrawPanel.getInstance();
        this.add(drawPanel, BorderLayout.CENTER);
        JPanel settingsPanel = SettingsPanel.getInstance();
        this.add(settingsPanel, BorderLayout.EAST);
        this.pack();
        this.setVisible(true);
    }
    //doesn't need to be explicitly called
}
