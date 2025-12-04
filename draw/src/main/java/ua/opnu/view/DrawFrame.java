package ua.opnu.view;

import ua.opnu.model.DrawShape;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Главное окно программы Draw.
 */
public class DrawFrame extends JFrame {

    // Область для рисования фигур
    private final PaintSurface surface;

    public DrawFrame(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());

        // Область рисования
        surface = new PaintSurface();
        surface.setBorder(new LineBorder(Color.GRAY));

        // Верхняя панель с кнопками
        JPanel buttonPanel = createButtonPanel();

        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(surface, BorderLayout.CENTER);
    }

    /**
     * Создаём панель с кнопками выбора фигуры и кнопкой Clear.
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Кнопка прямоугольника
        BigTextButton rect = new BigTextButton("Rectangle");
        rect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_RECTANGLE));
        buttonPanel.add(rect);

        // Кнопка закруглённого прямоугольника
        BigTextButton roundedRect = new BigTextButton("Rounded rect");
        roundedRect.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ROUNDED_RECT));
        buttonPanel.add(roundedRect);

        // Кнопка эллипса (задание 4.2)
        BigTextButton ellipse = new BigTextButton("Ellipse");
        ellipse.addActionListener(e -> surface.setShapeType(DrawShape.SHAPE_ELLIPSE));
        buttonPanel.add(ellipse);

        // Кнопка Clear (доп. балл)
        BigTextButton clear = new BigTextButton("Clear");
        clear.addActionListener(e -> surface.clearShapes());
        buttonPanel.add(clear);

        return buttonPanel;
    }
}
