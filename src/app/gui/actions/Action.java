package app.gui.actions;

import app.gui.enums.ActionCommand;
import app.gui.frame.DrawPanel;

public abstract class Action {

    public final ActionCommand actionCommand;
    protected final DrawPanel drawPanel = DrawPanel.getInstance();

    protected Action(final ActionCommand actionCommand) {
        this.actionCommand = actionCommand;
    }

    public abstract void runAction();
}
