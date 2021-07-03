package app.gui.actions;

import app.gui.actions.shapeActions.ColorChooseAction;
import app.gui.enums.ActionCommand;

import java.awt.*;

public abstract class AddShapeAction extends Action {
    protected AddShapeAction(final ActionCommand actionCommand) {
        super(actionCommand);
    }

    public int getWidth() {
        return 50;
    }

    public int getHeight() {
        return 50;
    }

    public Color getColor() {
        return ColorChooseAction.getLastPickedColor();
    }

    public int getMouseX() {
        int x = drawPanel.getPreferredSize().width / 2;
        if (drawPanel.getMousePosition() != null) {
            x = drawPanel.getMousePosition().x;
        }
        return x;
    }

    public int getMouseY() {
        int y = drawPanel.getPreferredSize().height / 2;
        if (drawPanel.getMousePosition() != null) {
            y = drawPanel.getMousePosition().y;
        }
        return y;
    }

}
