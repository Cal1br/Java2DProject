package app.gui.actions.groupActions;

import app.gui.actions.Action;
import app.gui.enums.ActionCommand;
import app.gui.frame.tabs.AllGroupsPanel;

public class DeleteGroupAction extends Action {

    public DeleteGroupAction() {
        super(ActionCommand.DELETE_GROUP);
    }

    @Override
    public void runAction() {
        AllGroupsPanel.deleteSelectedGroup();
    }
}
