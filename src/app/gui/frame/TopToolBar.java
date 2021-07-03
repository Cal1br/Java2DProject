package app.gui.frame;

import app.gui.listeners.MenuListener;
import app.gui.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TopToolBar extends JToolBar {
    private static final TopToolBar instance = new TopToolBar();
    private final DrawPanel drawPanel = DrawPanel.getInstance();
    private final JColorChooser colorChooser = new JColorChooser();
    private final JTextField widthTF = new JTextField();
    private final JTextField heightTF = new JTextField();
    private final JTextField rotationTF = new JTextField();

    private TopToolBar() {
        final ImageIcon colorPickerIcon = new ImageIcon("resources/pick.png");
        Image image = colorPickerIcon.getImage();
        Image newimg = image.getScaledInstance(15, 15, Image.SCALE_SMOOTH);
        ImageIcon colorIcon = new ImageIcon(newimg);
        JButton colorButton = new JButton("Pick a Color");
        this.add(colorButton);
        colorButton.setActionCommand("CHOOSE_COLOR");
        colorButton.addActionListener(MenuListener.getInstance());
        colorButton.setIcon(colorIcon);
        ActionListener listener = MenuListener.getInstance();
        widthTF.addActionListener(listener);
        widthTF.setActionCommand("SHAPE_CHANGE_VALUE");
        heightTF.addActionListener(listener);
        heightTF.setActionCommand("SHAPE_CHANGE_VALUE");
        rotationTF.addActionListener(listener);
        rotationTF.setActionCommand("SHAPE_CHANGE_VALUE");
        JLabel widthL = new JLabel("Width");
        this.add(widthL);
        this.add(widthTF);
        JLabel heightL = new JLabel("Height");
        this.add(heightL);
        this.add(heightTF);
        JLabel rotationL = new JLabel("Rotation");
        this.add(rotationL);
        this.add(rotationTF);
    }

    public static TopToolBar getInstance() {
        return instance;
    }

    public Color getSelectedColor() {
        Color color = JColorChooser.showDialog(null, "Pick a color", Color.BLACK);
        if (color == null) {
            color = Color.BLACK;
        }
        System.out.println(color);
        return color;
    }

    public void updateTextFields() {
        final Shape selectedShape = drawPanel.getSelectedShape();
        widthTF.setText(Integer.toString(selectedShape.getWidth()));
        heightTF.setText(Integer.toString(selectedShape.getHeight()));
        rotationTF.setText(Integer.toString(selectedShape.getRotation()));
    }

    public void updateShape() {
        Shape selectedShape = DrawPanel.getInstance().getSelectedShape();
        selectedShape.setWidth(Integer.parseInt(widthTF.getText()));
        selectedShape.setHeight(Integer.parseInt(heightTF.getText()));
        selectedShape.setRotation(Integer.parseInt(rotationTF.getText()));
        drawPanel.repaint();
    }

    public void resetTextFields() {
        widthTF.setText("");
        heightTF.setText("");
        rotationTF.setText("");
    }
}
