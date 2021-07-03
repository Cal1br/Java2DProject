package app.gui.frame;

import app.gui.frame.tabs.AllFiguresPanel;
import app.gui.listeners.MyMouseListener;
import app.gui.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DrawPanel extends JPanel implements ActionListener {
    private static final DrawPanel instance = new DrawPanel();
    private static final List<List<Shape>> groups = new LinkedList<>();
    private final MouseListener mouseListener = new MyMouseListener(this);
    private Shape selectedShape = null;
    private List<Shape> selectedShapes = new LinkedList<>();
    private List<Shape> modelList = new LinkedList<>();

    private DrawPanel() {
        this.setPreferredSize(new Dimension(500, 500));
        this.addMouseListener(mouseListener);
    }

    public static List<List<Shape>> getGroups() {
        return groups;
    }

    public static DrawPanel getInstance() {
        return instance;
    }

    public List<Shape> getSelectedShapes() {
        return selectedShapes;
    }

    public void setSelectedShapes(final List<Shape> selectedShapes) {
        this.selectedShapes = selectedShapes;
    }


    public Shape getSelectedShape() {
        return selectedShape;
    }

    public void setSelectedShape(final Shape selectedShape) {
        this.selectedShape = selectedShape;
        if (selectedShape != null) {
            TopToolBar.getInstance().updateTextFields();
        } else {
            TopToolBar.getInstance().resetTextFields();
        }
        repaint();
    }

    public List<Shape> getModelList() {
        return modelList;
    }

    public void setModelList(final List<Shape> modelList) {
        this.modelList = modelList;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Това е за anti-aliasing
        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
        );
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHints(rh);
        for (Shape shape : modelList) {
            shape.paintComponent(g2d);
        }
        for (final Shape shape : selectedShapes) {
            shape.selectedAnimation(g);
        }
        if (selectedShape != null) {
            selectedShape.selectedAnimation(g);
        }
    }

    public void addShape(final Shape s) {
        this.modelList.add(s);
        AllFiguresPanel.addShape();
        repaint();
    }


    @Override //от таймера се пуска
    public void actionPerformed(final ActionEvent e) {
        final Point location = this.getMousePosition();
        if (selectedShapes.isEmpty()) { //няма значение за performance този if (теоретично), заради branch prediction
            selectedShape.setCoordinates(location);
            repaint();
        } else {
            selectedShape.setCoordinates(location);
            MyMouseListener listener = (MyMouseListener) mouseListener;
            Map<Shape, Point> relativePoints = listener.getRelativePoints();
            selectedShapes.remove(selectedShape);
            for (Shape shape : selectedShapes) {
                Point moveto = new Point(selectedShape.getCenterPoint().x + relativePoints.get(shape).x, selectedShape.getCenterPoint().y + relativePoints.get(shape).y);
                shape.setCoordinates(moveto);
            }
            selectedShapes.add(selectedShape);
            repaint();
        }

    }

    public void deleteShape(final Shape selectedShape) {
        modelList.remove(selectedShape);
        repaint();
    }
}