package ua.opnu;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainFrame frame = new MainFrame("Rock-Paper-Scissors");
            frame.setVisible(true);
        });
    }
}
