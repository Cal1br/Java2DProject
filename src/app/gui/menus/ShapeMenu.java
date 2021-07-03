package app.gui.menus;

import app.gui.listeners.MenuListener;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ShapeMenu extends JMenu {
    public ShapeMenu(final String s) {
        super(s);
        //todo custom shortcut alt+a, ey tuy za add
        this.setMnemonic(KeyEvent.VK_A);
        this.getAccessibleContext().setAccessibleDescription("A menu for adding app.gui.shapes");
        final JMenuItem addRectangle = new JMenuItem("Add Rectangle", KeyEvent.VK_R);
        addRectangle.setActionCommand("ADD_SHAPE_RECTANGLE");
        addRectangle.getAccessibleContext().setAccessibleDescription(
                "Adds Rectangle on mouse click");
        ActionListener menuListener = MenuListener.getInstance();
        addRectangle.addActionListener(menuListener);
        this.add(addRectangle);
        //-------
        final JMenuItem addCircle = new JMenuItem("Add Circle", KeyEvent.VK_C);
        addCircle.setActionCommand("ADD_SHAPE_CIRCLE");
        addCircle.addActionListener(menuListener);
        this.add(addCircle);
        final JMenuItem addTriangle = new JMenuItem("Add Triangle", KeyEvent.VK_T);
        addTriangle.setActionCommand("ADD_SHAPE_TRIANGLE");
        addTriangle.addActionListener(menuListener);
        this.add(addTriangle);
        final JMenuItem addTestShape = new JMenuItem("Add Test Shape", KeyEvent.VK_A);
        addTestShape.setActionCommand("ADD_SHAPE_TEST");
        addTestShape.addActionListener(menuListener);
        this.add(addTestShape);
    }
}
