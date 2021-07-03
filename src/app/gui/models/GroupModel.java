package app.gui.models;

import app.gui.models.dto.Group;
import app.gui.shapes.Shape;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class GroupModel extends AbstractTableModel {
    private List<Group> groups;

    public GroupModel(final List<List<Shape>> groups) {
        this.groups = new ArrayList<>();

        for (int i = 0; i < groups.size(); i++) {
            final List<Shape> groupList = groups.get(i);
            this.groups.add(new Group(groupList, "Group " + i));
        }
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(final List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public int getRowCount() {
        return groups.size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        return groups.get(rowIndex).getGroupName();
    }

    @Override
    public boolean isCellEditable(final int row, final int column) {
        return true;
    }

    @Override
    public void setValueAt(final Object value, final int rowIndex, final int column) {
        String newName = value.toString();
        groups.get(rowIndex).setGroupName(newName);
    }

    public Group getGroupAt(final int rowIndex) {
        return groups.get(rowIndex);
    }

    public String getColumnName(int columnIndex) {
        return "All Groups";
    }
}
