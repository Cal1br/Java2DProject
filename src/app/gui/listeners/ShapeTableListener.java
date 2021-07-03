package app.gui.listeners;

import app.gui.frame.DrawPanel;
import app.gui.models.ShapeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShapeTableListener implements MouseListener {

    @Override
    public void mouseClicked(final MouseEvent e) {
        Component component = e.getComponent();
        JTable jTable = (JTable) component;
        int selected = jTable.getSelectedRow();
        if (e.getClickCount() == 1) {
            final ShapeModel model = (ShapeModel) jTable.getModel();
            DrawPanel.getInstance().setSelectedShape(model.getShapeAt(selected));
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


}
