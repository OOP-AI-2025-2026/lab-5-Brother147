package ua.opnu;

import ua.opnu.view.DrawFrame;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DrawFrame frame = new DrawFrame("Програма Draw");
            frame.setVisible(true);
        });
    }
}
