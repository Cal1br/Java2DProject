package app.gui.frame.tabs;

import app.gui.frame.DrawPanel;
import app.gui.listeners.GroupTableListener;
import app.gui.listeners.MenuListener;
import app.gui.models.GroupModel;
import app.gui.models.dto.Group;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class AllGroupsPanel extends JPanel {
    private static final JTable groupsTable = new JTable();
    private static final GroupTableListener tableListener = new GroupTableListener();

    public AllGroupsPanel() {
        groupsTable.addMouseListener(tableListener);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setMaximumSize(new Dimension(300, 600));
        this.setPreferredSize(new Dimension(180, 600));
        JScrollPane scroller = new JScrollPane(groupsTable);
        scroller.setMaximumSize(new Dimension(300, 600));
        scroller.setPreferredSize(new Dimension(300, 600));
        this.add(scroller);
        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setActionCommand("DELETE_GROUP");
        deleteBtn.addActionListener(MenuListener.getInstance());
        this.add(deleteBtn);
        fillPanel();
    }

    public static void deleteSelectedGroup() {
        final GroupModel model = (GroupModel) groupsTable.getModel();
        final Group groupAt = model.getGroupAt(tableListener.getSelected());
        DrawPanel.getGroups().remove(groupAt.getElements());
        groupsTable.setModel(new GroupModel(DrawPanel.getGroups()));
    }

    public static void loadGroups(final List<Group> groups) {
        final GroupModel dataModel = new GroupModel(new ArrayList<>());
        dataModel.setGroups(groups);
        groupsTable.setModel(dataModel);
    }

    public static List<Group> getGroups() {
        return ((GroupModel) groupsTable.getModel()).getGroups();
    }

    public static void refresh() {
        groupsTable.setModel(new GroupModel(DrawPanel.getGroups()));
    }

    public void fillPanel() {
        groupsTable.setModel(new GroupModel(DrawPanel.getGroups()));
    }

}
