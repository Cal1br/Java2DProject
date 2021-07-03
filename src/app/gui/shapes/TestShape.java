package app.gui.shapes;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Path2D;

public class TestShape extends Shape {
    private int radius;

    public TestShape(final int coordinateX, final int coordinateY, final int width) {
        super(coordinateX, coordinateY);
        this.radius = width;
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
        Ellipse2D.Double ellipse = new Ellipse2D.Double(getCoordinateX() - (radius / 2.0), getCoordinateY() - (radius / 2.0), getHeight(), getWidth());
        AffineTransform reset = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation), getCenterPoint().getX(), getCenterPoint().y);
        if (fill) {
            g2d.fill(ellipse);
        } else {
            g2d.setPaint(Color.GREEN);
            g2d.draw(ellipse);
        }
        Path2D.Double p = new Path2D.Double();
        p.moveTo(coordinateX, coordinateY - radius / 2);
        p.lineTo(coordinateX, coordinateY + radius / 2);
        p.closePath();
        g2d.setPaint(Color.YELLOW);
        g2d.draw(p);
        g2d.rotate(Math.toRadians(30),getCenterPoint().getX(),getCenterPoint().y);
        g2d.draw(p);

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
        return rotation;
    }

    @Override
    public void setRotation(final int rotation) {
        this.rotation = (short) rotation;
    }
}
