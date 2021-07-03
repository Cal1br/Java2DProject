package app.gui.frame;

import app.gui.menus.FileMenu;
import app.gui.menus.GroupMenu;
import app.gui.menus.ShapeMenu;

import javax.swing.*;

public class MenuBar extends JMenuBar {

    public MenuBar() {
        JMenu fileMenu = new FileMenu("File");
        this.add(fileMenu);
        JMenu shapeMenu = new ShapeMenu("Add Shape");
        this.add(shapeMenu);
        JMenu groupMenu = new GroupMenu("Groups");
        this.add(groupMenu);
        this.setVisible(true);
    }
}
