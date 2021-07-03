package app.gui.models;

import app.gui.shapes.Shape;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ShapeModel extends AbstractTableModel {

    private final List<Shape> shapes;

    public ShapeModel(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public int getRowCount() {
        return shapes.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        return shapes.get(rowIndex).getName();
    }

    public String getColumnName(int columnIndex) {
        return "All Shapes";
    }

    public Shape getShapeAt(int row) {
        return shapes.get(row);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return true;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        String newName = value.toString();
        getShapeAt(row).setName(newName);
    }
}
