package PRODIGY_02;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuessingGame {
    private int maximumAttempts;
    private int countNumberOfAttempts; // track number of attempts

    // Creating a random object
    Random random = new Random();

    public static void main(String[] args) {
        new MyFrame();
    }

    /*
     * Playing on easy mode
     * generate numbers in the range of 10 (3 attempts)
     */
    public int easyModeNumber() {
        maximumAttempts = 3;
        countNumberOfAttempts = 0;
        return random.nextInt(10) + 1;
    }

    /*
     * Playing on medium mode
     * generate numbers in the range of 50 (7 attempts)
     */
    public int mediumModeNumber() {
        maximumAttempts = 7;
        countNumberOfAttempts = 0;
        return random.nextInt(50) + 1;
    }

    /*
     * Playing on advanced mode
     * generate numbers in the range of 100 (15 attempts)
     */
    public int advancedModeNumber() {
        maximumAttempts = 15;
        countNumberOfAttempts = 0;
        return random.nextInt(100) + 1;
    }

    // obtain attempts user made to play the game
    public int getNumberOfAttempts() {
        return this.countNumberOfAttempts;
    }

    public int getMaxAttempts() {
        return this.maximumAttempts;
    }

    public void incrementAttempts() {
        this.countNumberOfAttempts++;
    }
}

class MyFrame extends JFrame implements ActionListener {
    private JButton button;
    private JPanel panel;
    private GuessingGame game;

    public MyFrame() {
        game = new GuessingGame();

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        button = new JButton("Start Game");
        button.setPreferredSize(new Dimension(200, 50));
        button.addActionListener(this);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        panel.add(button, gridBagConstraints);

        this.add(panel);

        this.setTitle("Guessing Game");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        String[] gameOptions = {"1. Easy mode", "2. Medium mode", "3. Advanced mode"};
        int mode = JOptionPane.showOptionDialog(panel,
                "Choose a difficulty level:",
                "Select Mode",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null, gameOptions, gameOptions[0]);

        int guessNumber = 0;
        int maxAttempts = 0;
        switch (mode) {
            case 0: // Easy
                guessNumber = game.easyModeNumber();
                maxAttempts = game.getMaxAttempts();
                break;
            case 1: // Medium
                guessNumber = game.mediumModeNumber();
                maxAttempts = game.getMaxAttempts();
                break;
            case 2: // Advanced
                guessNumber = game.advancedModeNumber();
                maxAttempts = game.getMaxAttempts();
                break;
            default:
                return;
        }

        boolean guessedNumberCorrectly = false; // track if user guessed the correct number
        String guessInStringForm = null; // initializing the guess in the string form
        for (int attempts = 0; attempts < maxAttempts; attempts++) {
            game.incrementAttempts();
            guessInStringForm = JOptionPane.showInputDialog(panel, "Attempt " + (game.getNumberOfAttempts()) + " of " + maxAttempts + ". Enter your guess:");
            if (guessInStringForm == null) // user pressed the cancel button
            {
                JOptionPane.showMessageDialog(panel, "You are exiting the game, bye!");
                return;
            }

            int guess = Integer.parseInt(guessInStringForm);
            if (guess == guessNumber) {
                JOptionPane.showMessageDialog(panel, "Congratulations! You guessed the number correctly in " + game.getNumberOfAttempts() + " attempts.");
                guessedNumberCorrectly = true;
                break;
            } else if (guess < guessNumber) {
                JOptionPane.showMessageDialog(panel, "That guess is too low! Try again. Number of attempts left: " + (maxAttempts - game.getNumberOfAttempts()));
            } else {
                JOptionPane.showMessageDialog(panel, "That guess is too high! Try again. Number of attempts left: " + (maxAttempts - game.getNumberOfAttempts()));
            }
        }

        if (!guessedNumberCorrectly) {
            JOptionPane.showMessageDialog(panel, "Sorry, you've reached your maximum attempts. The correct number was " + guessNumber + ".");
        }
    }
}
