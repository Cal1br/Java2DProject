package app.gui.actions.groupActions;

import app.gui.actions.Action;
import app.gui.enums.ActionCommand;
import app.gui.frame.DrawPanel;
import app.gui.frame.tabs.AllGroupsPanel;


public class SaveGroupAction extends Action {
    public SaveGroupAction() {
        super(ActionCommand.SAVE_GROUP);

    }

    @Override
    public void runAction() {
        DrawPanel.getGroups().add(DrawPanel.getInstance().getSelectedShapes());
        AllGroupsPanel.refresh();
    }
}
