package app.gui.shapes;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class TriangleShape extends Shape {

    private int width;
    private int height;

    public TriangleShape(final int coordinateX, final int coordinateY, final int width, final int height) {
        super(coordinateX, coordinateY);
        this.width = width;
        this.height = height;
    }

    private static double calculateArea(final Point a, final Point b, final Point c) {
        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;
        int x3 = c.x;
        int y3 = c.y;
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) +
                x3 * (y1 - y2)) / 2.0);
    }

    @Override
    public boolean contains(final Point point) {
        return contains(point.x, point.y);
    }

    @Override
    public boolean contains(final int x, final int y) {
        Point p = new Point(x, y);
        Point a = new Point(coordinateX - this.width / 2, coordinateY + height);
        Point b = new Point(coordinateX + this.width / 2, coordinateY + height);
        Point c = new Point(coordinateX, coordinateY);
        double area = calculateArea(a, b, c);
        double area1 = calculateArea(p, b, c);
        double area2 = calculateArea(p, a, c);
        double area3 = calculateArea(p, a, b);
        return (area == area1 + area2 + area3);
    }

    @Override
    public Point getCenterPoint() {
        return new Point(this.coordinateX, this.coordinateY + height / 2);
    }

    @Override
    public void setCoordinates(final Point location) {
        setCoordinateX(location.x);
        setCoordinateY(location.y - this.height / 2);
    }

    public void paintComponent(final Graphics g, final Paint paint, final boolean fill) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(paint);
        Path2D.Double p = new Path2D.Double();
        p.moveTo(coordinateX, coordinateY);
        p.lineTo(coordinateX - width / 2.0, coordinateY + this.height);
        p.lineTo(coordinateX + width / 2.0, coordinateY + this.height);
        p.closePath();
        AffineTransform reset = g2d.getTransform();
        g2d.rotate(Math.toRadians(rotation), getCenterPoint().getX(), getCenterPoint().y);
        if (fill) {
            g2d.fill(p);
        } else {
            g2d.draw(p);
        }
        g2d.setTransform(reset);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

    @Override
    public void setWidth(final int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return this.height;
    }

    @Override
    public void setHeight(final int height) {
        this.height = height;
    }

    @Override
    public int getRotation() {
        return 0;
    }

    @Override
    public void setRotation(final int rotation) {
        this.rotation = (short) rotation;
    }
}
