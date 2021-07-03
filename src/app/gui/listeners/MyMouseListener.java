package app.gui.listeners;

import app.gui.frame.DrawPanel;
import app.gui.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMouseListener implements MouseListener {
    private final DrawPanel origin;
    private final Timer timer;
    private final Map<Shape, Point> relativePoints = new HashMap<>();

    public MyMouseListener(DrawPanel origin) {
        this.origin = origin;
        this.timer = new Timer(5, origin);
    }

    public Map<Shape, Point> getRelativePoints() {
        return relativePoints;
    }

    @Override
    public void mouseClicked(final MouseEvent e) {
/*        final Shape selected = origin.getSelectedShape();
        final List<Shape> modelList = origin.getModelList();
        final List<Shape> selectedShapes = origin.getSelectedShapes();
        for (Shape shape : modelList) {
            if (shape.contains(e.getPoint())) {
                if (KeyListener.isShiftPressed()) {
                    if (!selectedShapes.contains(shape)) {
                        selectedShapes.add(shape);
                        origin.setSelectedShape(shape);
                    }
                    origin.setSelectedShape(shape);
                    break;
                } else {
                    selectedShapes.clear();
                    origin.setSelectedShape(shape);
                }
                break;
            }

        }*/
    }

    @Override
    public void mousePressed(final MouseEvent e) {
        Shape selected = origin.getSelectedShape();
        final List<Shape> modelList = origin.getModelList();
        final List<Shape> selectedShapes = origin.getSelectedShapes();

        for (Shape shape : modelList) {
            if (shape.contains(e.getPoint())) {
                if (KeyListener.isShiftPressed()) {
                    if (!selectedShapes.contains(shape)) {
                        selectedShapes.add(shape);
                    }
                    if (selected != null && !selectedShapes.contains(selected)) {
                        selectedShapes.add(selected);
                    }
                    DrawPanel.getInstance().repaint();
                    return;
                } else if (selectedShapes.contains(shape) || (selected != null && selected.equals(shape))) { //ako e selectnat dragvame
                    origin.setSelectedShape(shape);
                    if (selectedShapes.contains(shape)) {
                        relativePoints.clear();
                        selectedShapes.remove(shape);
                        for (Shape shapefromselected : selectedShapes) {
                            Point point = new Point(shapefromselected.getCenterPoint().x - shape.getCenterPoint().x, shapefromselected.getCenterPoint().y - shape.getCenterPoint().y);
                            relativePoints.put(shapefromselected, point);
                        }
                        selectedShapes.add(shape);
                        timer.start();
                        return;
                    } else {
                        timer.start();
                        return;
                    }
                } else {
                    selectedShapes.clear();
                    origin.setSelectedShape(shape);

                    DrawPanel.getInstance().repaint();
                    return;
                }

            }
            //woho selected shape found
        }
        origin.setSelectedShape(null);
        origin.getSelectedShapes().clear();

    }


    @Override
    public void mouseReleased(final MouseEvent e) {
        timer.stop();
    }

    @Override
    public void mouseEntered(final MouseEvent e) {

    }

    @Override
    public void mouseExited(final MouseEvent e) {

    }
}