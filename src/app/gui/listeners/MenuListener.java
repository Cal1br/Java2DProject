package app.gui.listeners;

import app.gui.actions.Action;
import app.gui.actions.Actions;
import app.gui.enums.ActionCommand;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListener implements ActionListener {
    private static final MenuListener instance = new MenuListener();

    private MenuListener() {
    }

    public static MenuListener getInstance() {
        return instance;
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        ActionCommand command = ActionCommand.valueOf(e.getActionCommand());

        Actions.getActions(command).parallelStream().forEach(Action::runAction);
    }
}
