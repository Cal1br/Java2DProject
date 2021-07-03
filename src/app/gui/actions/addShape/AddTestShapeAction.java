package app.gui.actions.addShape;

import app.gui.actions.AddShapeAction;
import app.gui.enums.ActionCommand;
import app.gui.shapes.CircleShape;
import app.gui.shapes.TestShape;
import app.gui.shapes.TriangleShape;

public class AddTestShapeAction extends AddShapeAction {
    public AddTestShapeAction() {
        super(ActionCommand.ADD_SHAPE_TEST);
    }

    @Override
    public void runAction() {
        final TestShape testShape = new TestShape(getMouseX(), getMouseY(), getWidth());
        testShape.setColor(getColor());
        drawPanel.addShape(testShape);
    }
}
