package app.gui.actions.shapeActions;

import app.gui.actions.Action;
import app.gui.enums.ActionCommand;
import app.gui.frame.tabs.AllFiguresPanel;

public class DeleteShapeAction extends Action {
    public DeleteShapeAction() {
        super(ActionCommand.DELETE_SHAPE);
    }

    @Override
    public void runAction() {
        AllFiguresPanel.deleteShape(drawPanel.getSelectedShape());
    }
}
