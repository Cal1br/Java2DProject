package app.gui.menus;

import app.gui.listeners.MenuListener;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class GroupMenu extends JMenu {
    public GroupMenu(final String s) {
        super(s);
        this.setMnemonic(KeyEvent.VK_G);
        this.getAccessibleContext().setAccessibleDescription("Group menu, for managing groups");
        JMenuItem saveGroup = new JMenuItem("Save Group", KeyEvent.VK_G);
        saveGroup.getAccessibleContext().setAccessibleDescription(
                "Saves group");
        saveGroup.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
        saveGroup.setActionCommand("SAVE_GROUP");
        MenuListener menuListener = MenuListener.getInstance();
        saveGroup.addActionListener(menuListener);
        this.add(saveGroup);
    }
}
