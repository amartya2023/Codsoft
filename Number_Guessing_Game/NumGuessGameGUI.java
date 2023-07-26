import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class NumGuessGameGUI {
    private static int tries;
    private static int rmNum;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Number Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new FlowLayout());
        frame.add(panel, BorderLayout.CENTER);

        JLabel label = new JLabel("Guess a number between 1 and 100:");
        JTextField textField = new JTextField(10);
        JButton guessButton = new JButton("Guess");

        panel.add(label);
        panel.add(textField);
        panel.add(guessButton);

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = textField.getText();
                try {
                    int guess = Integer.parseInt(input);
                    tries++;

                    if (guess == rmNum) {
                        JOptionPane.showMessageDialog(frame, "Congratulations! You guessed the number.\nIt only took you " + tries + " guesses.");
                        tries = 0;
                        int response = JOptionPane.showConfirmDialog(frame, "Would you like to play this game again?", "Play Again", JOptionPane.YES_NO_OPTION);
                        if (response == JOptionPane.YES_OPTION) {
                            rmNum = generateRandomNumber();
                        } else {
                            frame.dispose();
                        }
                    } else if (guess > rmNum) {
                        JOptionPane.showMessageDialog(frame, "Your guess is too high! Try again...");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Your guess is too low! Try again...");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
        rmNum = generateRandomNumber();
    }

    private static int generateRandomNumber() {
        Random rm = new Random();
        return rm.nextInt(100) + 1;
    }
}
