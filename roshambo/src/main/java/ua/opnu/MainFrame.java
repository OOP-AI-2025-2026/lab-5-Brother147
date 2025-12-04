package ua.opnu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Главное окно игры "Камень-ножницы-бумага".
 */
public class MainFrame extends JFrame implements ActionListener {

    private final JLabel playerLabel;
    private final JLabel computerLabel;

    private final Random random = new Random();

    public MainFrame(String title) throws HeadlessException {
        super(title);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(400, 250);
        setLocationRelativeTo(null);

        getContentPane().setLayout(new BorderLayout());

        // Центральная панель с подписями
        JPanel centerPanel = new JPanel(new GridLayout(2, 1));
        playerLabel = new JLabel("Player: -", SwingConstants.CENTER);
        computerLabel = new JLabel("Computer: -", SwingConstants.CENTER);
        playerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        computerLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        centerPanel.add(playerLabel);
        centerPanel.add(computerLabel);

        getContentPane().add(centerPanel, BorderLayout.CENTER);

        // Нижняя панель с кнопками выбора хода игрока
        JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton rockButton = new JButton("Rock");
        rockButton.setActionCommand("ROCK");
        rockButton.addActionListener(this);
        buttonsPanel.add(rockButton);

        JButton paperButton = new JButton("Paper");
        paperButton.setActionCommand("PAPER");
        paperButton.addActionListener(this);
        buttonsPanel.add(paperButton);

        JButton scissorsButton = new JButton("Scissors");
        scissorsButton.setActionCommand("SCISSORS");
        scissorsButton.addActionListener(this);
        buttonsPanel.add(scissorsButton);

        getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    }

    /**
     * Генерация случайной фигуры для компьютера.
     */
    private GameShape generateShape() {
        int value = random.nextInt(3);
        return switch (value) {
            case 0 -> new Rock();
            case 1 -> new Paper();
            default -> new Scissors();
        };
    }

    /**
     * Проверка победителя.
     *
     * @return 1  — выиграл игрок
     *        -1  — выиграл компьютер
     *         0  — ничья
     */
    private int checkWinner(GameShape player, GameShape computer) {
        return player.compare(computer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameShape playerShape;
        String command = e.getActionCommand();

        switch (command) {
            case "ROCK" -> playerShape = new Rock();
            case "PAPER" -> playerShape = new Paper();
            case "SCISSORS" -> playerShape = new Scissors();
            default -> {
                return;
            }
        }

        GameShape computerShape = generateShape();

        playerLabel.setText("Player: " + playerShape);
        computerLabel.setText("Computer: " + computerShape);

        int result = checkWinner(playerShape, computerShape);

        String message = "Player: " + playerShape + "\n"
                + "Computer: " + computerShape + "\n\n";

        // Вот тут та самая логика из заготовки:
        switch (result) {
            case -1:
                message += "Computer has won!";
                break;
            case 0:
                message += "It's a tie!";
                break;
            case 1:
                message += "Player has won!";
        }

        JOptionPane.showMessageDialog(this, message, "Result", JOptionPane.INFORMATION_MESSAGE);
    }
}
