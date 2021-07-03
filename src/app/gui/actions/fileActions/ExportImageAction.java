package app.gui.actions.fileActions;

import app.gui.actions.Action;
import app.gui.enums.ActionCommand;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ExportImageAction extends Action {
    private final JFileChooser fileChooser = new JFileChooser();

    public ExportImageAction() {
        super(ActionCommand.EXPORT_IMAGE);
        fileChooser.setDialogTitle("Specify where to save");
        fileChooser.setFileFilter(new FileNameExtensionFilter("JPEG", "jpeg"));
    }

    @Override
    public void runAction() {
        int userSelection = fileChooser.showSaveDialog(drawPanel);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            if (!fileToSave.getAbsolutePath().endsWith(".jpeg")) {
                fileToSave = new File(fileToSave + ".jpeg");
            }
            final BufferedImage imageBuffer;
            try {
                imageBuffer = new Robot().createScreenCapture(drawPanel.getBounds());
            } catch (AWTException e1) {
                e1.printStackTrace();
                return;
            }
            Graphics2D graphics2D = imageBuffer.createGraphics();
            drawPanel.paint(graphics2D);

            try {
                ImageIO.write(imageBuffer, "jpeg", fileToSave);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
