import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ATM {
    
    int PIN=2580;
    float Totalbalance=1000000;

    public void showATMGUI() {
        JFrame frame = new JFrame("ATM Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(5, 2));
        frame.add(panel, BorderLayout.CENTER);

        JLabel pinLabel = new JLabel("Enter your PIN:");
        JTextField pinField = new JTextField();
        panel.add(pinLabel);
        panel.add(pinField);

        JButton enterButton = new JButton("Enter");
        panel.add(enterButton);

        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredPinStr = pinField.getText();
                try {
                    int enteredPin = Integer.parseInt(enteredPinStr);
                    if (enteredPin == PIN) {
                        frame.dispose(); // Close the PIN entry window
                        showMainMenuGUI();
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid PIN!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid PIN format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        frame.setVisible(true);
    }

    private void showMainMenuGUI() {
        JFrame frame = new JFrame("ATM Machine");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(4, 1));
        frame.add(panel, BorderLayout.CENTER);

        JButton checkBalanceButton = new JButton("Check Balance");
        JButton withdrawButton = new JButton("Withdraw Money");
        JButton depositButton = new JButton("Deposit Money");
        JButton exitButton = new JButton("Exit");

        panel.add(checkBalanceButton);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(exitButton);

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "The balance is: " + Totalbalance, "Balance", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to withdraw:");
                try {
                    float amount = Float.parseFloat(amountStr);
                    if (amount > Totalbalance) {
                        JOptionPane.showMessageDialog(frame, "Insufficient Balance!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        Totalbalance -= amount;
                        JOptionPane.showMessageDialog(frame, "Money withdrawn successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amountStr = JOptionPane.showInputDialog(frame, "Enter amount to deposit:");
                try {
                    float amount = Float.parseFloat(amountStr);
                    Totalbalance += amount;
                    JOptionPane.showMessageDialog(frame, "Money deposited successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Invalid amount format!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                JOptionPane.showMessageDialog(null, "Thank you for using our ATM machine...", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}

public class ATMme {
    public static void main(String args[]) {
        ATM obj = new ATM();
        obj.showATMGUI();
    }
}
