package app.gui.actions;

import app.gui.actions.addShape.AddCircleAction;
import app.gui.actions.addShape.AddRectangleAction;
import app.gui.actions.addShape.AddTestShapeAction;
import app.gui.actions.addShape.AddTriangleAction;
import app.gui.actions.fileActions.ExportImageAction;
import app.gui.actions.fileActions.LoadFileAction;
import app.gui.actions.fileActions.SaveFileAction;
import app.gui.actions.groupActions.DeleteGroupAction;
import app.gui.actions.groupActions.SaveGroupAction;
import app.gui.actions.shapeActions.ColorChooseAction;
import app.gui.actions.shapeActions.DeleteShapeAction;
import app.gui.actions.shapeActions.ShapeChangeAction;
import app.gui.enums.ActionCommand;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Actions {

    private static final Set<Action> actions = new HashSet<>();

    static {
        registerActions();
    }

    private Actions() {
        //app.gui.actions container
    }

    public static Set<Action> getActions(final ActionCommand command) {
        return actions.stream().filter(action -> action.actionCommand == command).collect(Collectors.toSet());
    }

    private static void registerAction(final Action action) {
        actions.add(action);
    }

    private static void registerActions() {
        //Add shape
        registerAction(new AddRectangleAction());
        registerAction(new AddTriangleAction());
        registerAction(new AddCircleAction());

        //FIle app.gui.actions
        registerAction(new LoadFileAction());
        registerAction(new SaveFileAction());
        registerAction(new ExportImageAction());

        //Group options
        registerAction(new SaveGroupAction());
        registerAction(new DeleteGroupAction());

        //Shape options
        registerAction(new ColorChooseAction());
        registerAction(new DeleteShapeAction());
        registerAction(new ShapeChangeAction());
        registerAction(new AddTestShapeAction());
    }


}
