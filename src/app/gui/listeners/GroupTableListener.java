package app.gui.listeners;

import app.gui.frame.DrawPanel;
import app.gui.models.GroupModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GroupTableListener implements MouseListener {
    private int selected = -1;

    @Override
    public void mouseClicked(final MouseEvent e) {
        Component component = e.getComponent();
        JTable jTable = (JTable) component;
        selected = jTable.getSelectedRow();
        if (e.getClickCount() == 1) {
            final GroupModel model = (GroupModel) jTable.getModel();
            DrawPanel.getInstance().setSelectedShapes(model.getGroupAt(selected).getElements());
            DrawPanel.getInstance().repaint();
        }
    }

    @Override
    public void mousePressed(final MouseEvent e) {

    }

    @Override
    public void mouseReleased(final MouseEvent e) {

    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }

    public int getSelected() {
        return selected;
    }

}
