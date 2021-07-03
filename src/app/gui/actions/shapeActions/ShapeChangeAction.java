package app.gui.actions.shapeActions;

import app.gui.actions.Action;
import app.gui.enums.ActionCommand;
import app.gui.frame.TopToolBar;

public class ShapeChangeAction extends Action {
    public ShapeChangeAction() {
        super(ActionCommand.SHAPE_CHANGE_VALUE);
    }

    @Override
    public void runAction() {
        TopToolBar.getInstance().updateShape();
    }
}
