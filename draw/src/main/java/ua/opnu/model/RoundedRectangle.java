package ua.opnu.model;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 * Закруглённый прямоугольник.
 */
public class RoundedRectangle extends DrawShape {

    public RoundedRectangle() {
    }

    public RoundedRectangle(Point startPoint, Point endPoint) {
        super(startPoint, endPoint);
    }

    // Для отрисовки округлённого прямоугольника используем RoundRectangle2D.Double
    @Override
    public Shape getShape(Point startPoint, Point endPoint) {
        double x = Math.min(startPoint.getX(), endPoint.getX());
        double y = Math.min(startPoint.getY(), endPoint.getY());
        double w = Math.abs(startPoint.getX() - endPoint.getX());
        double h = Math.abs(startPoint.getY() - endPoint.getY());
        double arcW = 55.0;
        double arcH = 55.0;
        return new RoundRectangle2D.Double(x, y, w, h, arcW, arcH);
    }
}
