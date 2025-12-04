package ua.opnu.view;

import ua.opnu.model.DrawShape;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Область рисования.
 * Хранит список фигур и отвечает за обработку мыши и отрисовку.
 */
public class PaintSurface extends JPanel {

    private final List<DrawShape> shapes = new ArrayList<>();
    private DrawShape currentShape;
    private int currentShapeType = DrawShape.SHAPE_RECTANGLE;

    public PaintSurface() {
        setBackground(Color.WHITE);

        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                currentShape = DrawShape.newInstance(currentShapeType);
                Point p = e.getPoint();
                currentShape.setStartPoint(p);
                currentShape.setEndPoint(p);
                shapes.add(currentShape);
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (currentShape != null) {
                    currentShape.setEndPoint(e.getPoint());
                    repaint();
                }
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (currentShape != null) {
                    currentShape.setEndPoint(e.getPoint());
                    repaint();
                }
            }
        };

        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    /**
     * Выбор типа фигуры.
     */
    public void setShapeType(int shapeType) {
        this.currentShapeType = shapeType;
    }

    /**
     * Очистить все фигуры (для кнопки Clear).
     */
    public void clearShapes() {
        shapes.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        // Рисуем сетку (как в заготовке)
        g2.setColor(Color.LIGHT_GRAY);

        // Вертикальные линии через каждые 10 пикселей
        for (int i = 0; i < getSize().width; i += 10) {
            Shape line = new Line2D.Float(i, 0, i, getSize().height);
            g2.draw(line);
        }

        // Горизонтальные линии через каждые 10 пикселей
        for (int i = 0; i < getSize().height; i += 10) {
            Shape line = new Line2D.Float(0, i, getSize().width, i);
            g2.draw(line);
        }

        // Рисуем фигуры
        g2.setColor(Color.BLUE);
        for (DrawShape ds : shapes) {
            if (ds.getStartPoint() != null && ds.getEndPoint() != null) {
                Shape shape = ds.getShape(ds.getStartPoint(), ds.getEndPoint());
                if (shape != null) {
                    g2.draw(shape);
                }
            }
        }
    }
}
