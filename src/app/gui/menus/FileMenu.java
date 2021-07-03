package app.gui.menus;

import app.gui.listeners.MenuListener;

import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class FileMenu extends JMenu {
    public FileMenu(final String s) {
        super(s);
        this.setMnemonic(KeyEvent.VK_F);
        this.getAccessibleContext().setAccessibleDescription("File menu, for loading and saving");
        JMenuItem saveFile = new JMenuItem("Save File", KeyEvent.VK_S);
        saveFile.getAccessibleContext().setAccessibleDescription(
                "Saves files");
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
        saveFile.setActionCommand("SAVE_FILE");
        MenuListener menuListener = MenuListener.getInstance();
        saveFile.addActionListener(menuListener);
        this.add(saveFile);
        //-------
        JMenuItem loadFile = new JMenuItem("Load File", KeyEvent.VK_L);
        loadFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
        loadFile.setActionCommand("LOAD_FILE");
        loadFile.addActionListener(menuListener);
        this.add(loadFile);
        JMenuItem saveImage = new JMenuItem("Export Image", KeyEvent.VK_E);
        saveImage.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
        saveImage.setActionCommand("EXPORT_IMAGE");
        saveImage.addActionListener(menuListener);
        this.add(saveImage);

    }

}
