package app.gui.actions.addShape;

import app.gui.actions.AddShapeAction;
import app.gui.enums.ActionCommand;
import app.gui.shapes.CircleShape;

public class AddCircleAction extends AddShapeAction {

    public AddCircleAction() {
        super(ActionCommand.ADD_SHAPE_CIRCLE);

    }

    @Override
    public void runAction() {
        final CircleShape circleShape = new CircleShape(getMouseX(), getMouseY(), getWidth());
        circleShape.setColor(getColor());
        drawPanel.addShape(circleShape);
    }
}
