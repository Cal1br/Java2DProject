package app.gui.actions.fileActions;

import app.gui.actions.Action;
import app.gui.enums.ActionCommand;
import app.gui.frame.tabs.AllGroupsPanel;
import app.gui.utils.Serialization;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveFileAction extends Action {


    private final JFileChooser fileChooser = new JFileChooser();

    public SaveFileAction() {
        super(ActionCommand.SAVE_FILE);
        fileChooser.setDialogTitle("Specify a file to save");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Custom image format", "abcal"));
        fileChooser.setAcceptAllFileFilterUsed(false);
    }

    @Override
    public void runAction() {
        int userSelection = fileChooser.showSaveDialog(drawPanel);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".abcal")) {
                fileToSave = new File(fileToSave + ".abcal");
            }

            final ArrayList<Object> assArrayList = new ArrayList<>(drawPanel.getModelList());
            assArrayList.addAll(AllGroupsPanel.getGroups());

            final String modelList = Serialization.serializeObject(assArrayList);
            try (final FileWriter fileWriter = new FileWriter(fileToSave)) {
                fileWriter.write(modelList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        fileChooser.cancelSelection();
    }
}
