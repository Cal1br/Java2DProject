package app.gui.models.dto;

import app.gui.shapes.Shape;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private final List<Shape> elements;
    private String groupName;

    public Group(final List<Shape> elements, final String groupName) {
        this.elements = new ArrayList<>(elements);
        this.groupName = groupName;
    }

    public List<Shape> getElements() {
        return new ArrayList<>(elements);
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(final String groupName) {
        this.groupName = groupName;
    }
}
