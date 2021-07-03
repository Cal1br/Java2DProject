package app.gui.shapes;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Shape extends JComponent {

    private static final Map<Class<? extends Shape>, AtomicInteger> counts = new HashMap<>();
    protected Color color;
    protected String name;
    protected short rotation;
    protected int coordinateX;
    protected int coordinateY;

    public Shape(final int coordinateX, final int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        setName(getClass().getSimpleName() + getCount(this));
    }

    protected static int getCount(Shape shape) {
        final Class<? extends Shape> clazz = shape.getClass();
        if (counts.containsKey(clazz)) {
            return counts.get(clazz).incrementAndGet();
        } else {
            final AtomicInteger newCount = new AtomicInteger(1);
            counts.put(clazz, newCount);
            return newCount.get();
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(final String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(final int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(final int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public boolean contains(Point point) {
        return contains(point.x, point.y);
    }

    public abstract boolean contains(final int x, final int y);

    public abstract Point getCenterPoint();

    public abstract void setCoordinates(final Point location);

    public abstract void paintComponent(Graphics g, Paint paint, boolean fill);

    public void paintComponent(final Graphics g) {
        paintComponent(g, color, true);
    }

    public void selectedAnimation(final Graphics g) {
        paintComponent(g, Color.GREEN, false);
    }

    public abstract int getWidth();

    public abstract void setWidth(final int width);

    public abstract int getHeight();

    public abstract void setHeight(final int height);

    public abstract int getRotation();

    public abstract void setRotation(final int rotation);
}
