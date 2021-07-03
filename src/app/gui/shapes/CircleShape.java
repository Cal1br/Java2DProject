package app.gui.shapes;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

public class CircleShape extends Shape {

    private int radius;

    public CircleShape(final int coordinateX, final int coordinateY, int radius) {
        super(coordinateX, coordinateY);
        this.radius = radius;
    }

    @Override
    public boolean contains(final int x, final int y) {

        final int elementX = getCoordinateX();
        final int elementY = getCoordinateY();

        return Math.max(Math.abs(elementY - y), Math.abs(elementX - x)) < (getHeight() / 2);
    }

    @Override
    public Point getCenterPoint() {
        return new Point(this.coordinateX, this.coordinateY);
    }

    @Override
    public void setCoordinates(final Point location) {
        setCoordinateX(location.x);
        setCoordinateY(location.y);
    }

    @Override
    public void paintComponent(final Graphics g, final Paint paint, final boolean fill) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(paint);
        Ellipse2D.Double ellipse = new Ellipse2D.Double(getCoordinateX() - (getHeight() / 2), getCoordinateY() - (getHeight() / 2), getHeight(), getWidth());

        AffineTransform reset = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation), getCenterPoint().getX(), getCenterPoint().y);
        if (fill) {
            g2d.fill(ellipse);
        } else {
            g2d.draw(ellipse);
        }
        g2d.setTransform(reset);
    }


    @Override
    public int getWidth() {
        return this.radius;
    }

    @Override
    public void setWidth(final int width) {
        this.radius = width;
    }

    @Override
    public int getHeight() {
        return this.radius;
    }

    @Override
    public void setHeight(final int height) {
        this.radius = height;
    }

    @Override
    public int getRotation() {
        return this.rotation;
    }

    @Override
    public void setRotation(final int rotation) {
        this.rotation = (short) (rotation % 360);
    }

}
