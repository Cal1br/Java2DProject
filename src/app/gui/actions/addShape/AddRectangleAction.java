package app.gui.actions.addShape;

import app.gui.actions.AddShapeAction;
import app.gui.enums.ActionCommand;
import app.gui.shapes.RectangleShape;

public class AddRectangleAction extends AddShapeAction {

    public AddRectangleAction() {
        super(ActionCommand.ADD_SHAPE_RECTANGLE);

    }

    @Override
    public void runAction() {
        final RectangleShape rectangleShape = new RectangleShape(getMouseX(), getMouseY(),
                getWidth(), getHeight());
        rectangleShape.setColor(getColor());
        drawPanel.addShape(rectangleShape);
    }
}
