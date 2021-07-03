package app.gui.frame.tabs;

import app.gui.frame.DrawPanel;
import app.gui.listeners.MenuListener;
import app.gui.listeners.ShapeTableListener;
import app.gui.models.ShapeModel;
import app.gui.shapes.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class AllFiguresPanel extends JPanel {
    private static final JTable figuresTable = new JTable();

    public AllFiguresPanel() {
        MouseListener tableListener = new ShapeTableListener();
        figuresTable.addMouseListener(tableListener);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMaximumSize(new Dimension(300, 600));
        this.setPreferredSize(new Dimension(180, 600));
        JScrollPane scroller = new JScrollPane(figuresTable);
        scroller.setMaximumSize(new Dimension(300, 600));
        scroller.setPreferredSize(new Dimension(300, 600));
        this.add(scroller);
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setActionCommand("DELETE_SHAPE");
        deleteBtn.addActionListener(MenuListener.getInstance());
        this.add(deleteBtn);
        fillPanel();
    }

    public static void addShape() {
        figuresTable.setModel(new ShapeModel(DrawPanel.getInstance().getModelList()));
    }

    public static void deleteShape(final Shape shape) {
        DrawPanel drawPanel = DrawPanel.getInstance();
        drawPanel.deleteShape(shape);
        figuresTable.setModel(new ShapeModel(DrawPanel.getInstance().getModelList()));
    }

    public void fillPanel() {
        figuresTable.setModel(new ShapeModel(DrawPanel.getInstance().getModelList()));
    }
}
