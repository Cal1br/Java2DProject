package app.gui.actions.addShape;

import app.gui.actions.AddShapeAction;
import app.gui.enums.ActionCommand;
import app.gui.shapes.TriangleShape;

public class AddTriangleAction extends AddShapeAction {
    public AddTriangleAction() {
        super(ActionCommand.ADD_SHAPE_TRIANGLE);
    }

    @Override
    public void runAction() {
        final TriangleShape triangleShape = new TriangleShape(getMouseX(), getMouseY(), getWidth(), getHeight());
        triangleShape.setColor(getColor());
        drawPanel.addShape(triangleShape);
    }
}
