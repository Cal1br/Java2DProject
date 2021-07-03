package app.gui.actions.fileActions;

import app.gui.actions.Action;
import app.gui.enums.ActionCommand;
import app.gui.frame.tabs.AllFiguresPanel;
import app.gui.frame.tabs.AllGroupsPanel;
import app.gui.models.dto.Group;
import app.gui.shapes.Shape;
import app.gui.utils.Serialization;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LoadFileAction extends Action {

    private final JFileChooser fileChooser = new JFileChooser();

    public LoadFileAction() {
        super(ActionCommand.LOAD_FILE);
        fileChooser.setDialogTitle("Specify a file to load");
        fileChooser.setApproveButtonText("Load");
        fileChooser.setApproveButtonToolTipText("Load");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Custom image format", "abcal"));
        fileChooser.setAcceptAllFileFilterUsed(false);
    }

    @Override
    public void runAction() {
        int userSelection = fileChooser.showSaveDialog(drawPanel);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            final File fileToLoad = fileChooser.getSelectedFile();


            final StringBuilder modelHex = new StringBuilder();
            try (final Scanner scanner = new Scanner(fileToLoad)) {
                modelHex.append(scanner.next());
            } catch (IOException e) {
                e.printStackTrace();
            }
            final ArrayList<Object> modelList = Serialization.deserializeObject(modelHex.toString());

            final List<Shape> shapes = modelList.parallelStream().filter(Shape.class::isInstance).map(Shape.class::cast).collect(Collectors.toList());
            final List<Group> groups = modelList.parallelStream().filter(Group.class::isInstance).map(Group.class::cast).collect(Collectors.toList());

            drawPanel.setModelList(shapes);
            AllGroupsPanel.loadGroups(groups);
            AllFiguresPanel.addShape();
            drawPanel.repaint();
        }
        fileChooser.cancelSelection();
    }
}
