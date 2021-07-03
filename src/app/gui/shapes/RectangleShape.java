package app.gui.shapes;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class RectangleShape extends Shape {

    private final Rectangle rectangle; //това го използваме за някои сметки, композиция

    //TODO UH OH
    public RectangleShape(final int coordianteX, final int coordianteY, final int width, final int height) {
        super(coordianteX, coordianteY);
        rectangle = new Rectangle(coordinateX, coordinateY, width, height);
    }

    public int getWidth() {
        return rectangle.width;
    }

    public void setWidth(final int width) {
        this.rectangle.width = width;
    }

    public int getHeight() {
        return rectangle.height;
    }

    public void setHeight(final int height) {
        this.rectangle.height = height;
    }

    @Override
    public int getRotation() {
        return this.rotation;
    }

    @Override
    public void setRotation(final int rotation) {
        this.rotation = (short) (rotation % 360);
    }

    @Override
    public boolean contains(final int x, final int y) {
        return rectangle.contains(x, y);
    }

    @Override
    public Point getCenterPoint() {
        return new Point(this.getCoordinateX() + this.getWidth() / 2, this.getCoordinateY() + this.getHeight() / 2);
    }

    @Override
    public void setCoordinates(final Point location) {
        setCoordinateX(location.x - this.rectangle.width / 2);
        setCoordinateY(location.y - this.rectangle.height / 2);
    }

    @Override
    public void paintComponent(final Graphics g, final Paint paint, final boolean fill) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform reset = g2d.getTransform();
        g2d.setPaint(paint);
        g2d.rotate(Math.toRadians(rotation), getCenterPoint().getX(), getCenterPoint().y);
        if (fill) {
            g2d.fillRect(this.getCoordinateX(), this.getCoordinateY(), this.rectangle.width, this.rectangle.height);
        } else {
            g2d.drawRect(this.getCoordinateX(), this.getCoordinateY(), this.rectangle.width, this.rectangle.height);
        }
        g2d.setTransform(reset);
    }


    @Override
    public int getCoordinateX() {
        return this.rectangle.x;
    }

    @Override
    public void setCoordinateX(final int coordinateX) {
        this.rectangle.x = coordinateX;
    }

    @Override
    public int getCoordinateY() {
        return this.rectangle.y;
    }

    @Override
    public void setCoordinateY(final int coordinateY) {
        this.rectangle.y = coordinateY;
    }
}
