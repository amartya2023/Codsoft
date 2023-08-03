import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class wordcounter {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel instructionLabel = new JLabel("Enter a sentence to proceed:");
        JTextField inputField = new JTextField(30);
        JButton countButton = new JButton("Count Words");
        JTextArea outputArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        panel.add(instructionLabel);
        panel.add(inputField);
        panel.add(countButton);
        panel.add(scrollPane);

        countButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sentence = inputField.getText();
                if (sentence.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid sentence.");
                } else {
                    Map<String, Integer> wordFrequency = countWordsFrequency(sentence);
                    outputArea.setText("Total number of words in the sentence is: " + wordFrequency.size() + "\n");

                    for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                        outputArea.append("Count of " + entry.getKey() + " is: " + entry.getValue() + "\n");
                    }

                    outputArea.append("Unique words in the sentence:\n");
                    for (String word : wordFrequency.keySet()) {
                        outputArea.append(word + "\n");
                    }
                }
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private static Map<String, Integer> countWordsFrequency(String sentence) {
        String[] words = sentence.split(" ");
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            String key = word.toLowerCase();
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
        }

        return frequencyMap;
    }
}
