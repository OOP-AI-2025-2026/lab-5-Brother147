package ua.opnu.model;

import java.awt.Point;
import java.awt.Shape;

/*
 * Базовый класс "Фигура для рисования".
 * Хранит начальную и конечную точку, а также фабричный метод для создания
 * нужного подтипа фигуры.
 */
public abstract class DrawShape {

    public static final int SHAPE_RECTANGLE = 0;
    public static final int SHAPE_ROUNDED_RECT = 1;
    public static final int SHAPE_ELLIPSE = 2;

    protected Point startPoint;
    protected Point endPoint;

    public DrawShape() {
    }

    public DrawShape(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    /**
     * Фабричный метод: создаёт конкретную фигуру по типу.
     */
    public static DrawShape newInstance(int shapeType) {
        return switch (shapeType) {
            case SHAPE_RECTANGLE -> new Rectangle();
            case SHAPE_ROUNDED_RECT -> new RoundedRectangle();
            case SHAPE_ELLIPSE -> new Ellipse();
            default -> new Rectangle();
        };
    }

    /**
     * Построить Shape по двум точкам.
     */
    public abstract Shape getShape(Point startPoint, Point endPoint);

    public Point getStartPoint() {
        return startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }
}
