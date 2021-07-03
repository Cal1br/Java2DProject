package app.gui.actions.shapeActions;

import app.gui.actions.Action;
import app.gui.enums.ActionCommand;
import app.gui.frame.TopToolBar;
import app.gui.shapes.Shape;

import java.awt.*;
import java.util.List;

public class ColorChooseAction extends Action {

    private static Color lastPickedColor;
    private final TopToolBar topToolBar = TopToolBar.getInstance();

    public ColorChooseAction() {
        super(ActionCommand.CHOOSE_COLOR);
    }

    public static Color getLastPickedColor() {
        return lastPickedColor;
    }

    @Override
    public void runAction() {
        final List<Shape> selectedShapes = drawPanel.getSelectedShapes();
        Color color;
        color = topToolBar.getSelectedColor();
        final Shape selectedShape = drawPanel.getSelectedShape();
        if (selectedShape != null) {
            selectedShape.setColor(color);
        }
        if (!selectedShapes.isEmpty()) {
            for (final Shape shape : selectedShapes) {
                shape.setColor(color);
            }
        }
        lastPickedColor = color;
        drawPanel.repaint();
    }
}
