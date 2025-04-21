import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {

    private final Register register = new Register();
    private final JPanel registerPanel = new JPanel();
    private final JTextField input = new JTextField(10);
    private final PursePanel changePanel = new PursePanel();
    private final JTextArea outputArea = new JTextArea(10, 30); // new
    private final HistoryPanel historyPanel = new HistoryPanel();


    public RegisterPanel() {
        this.setBackground(Color.BLUE);

        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        this.add(scrollPane);


        // Set size of panel
        this.setPreferredSize(new Dimension(50, 50));


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  // BoxLayout to arrange components linearly

        // Size of Change Panel
        changePanel.setPreferredSize(new Dimension(1000, 1100));

        // Set up the input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBackground(Color.GREEN);
        inputPanel.add(new JLabel("Enter Amount: "));
        inputPanel.add(input);

        this.add(changePanel);
        this.add(inputPanel);


        // Add ActionListener
        input.addActionListener(new InputListener());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.add(inputPanel);
        bottomPanel.add(historyPanel);

        this.add(changePanel); // already in
        this.add(bottomPanel);

    }


    private class InputListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            try {
                // Parse the amount entered by the user
                double amount = Double.parseDouble(input.getText());

                // Get the purse with the change
                Purse purse = register.makeChange(amount);

                // Clear previous images
                changePanel.removeAll();

                // Display Images
                purse.getCash().forEach((denom, count) -> {
                    for (int i = 0; i < count; i++) {

                        // Rescale Images
                        ImageIcon originalIcon = new ImageIcon(denom.img());
                        Image scaledImage = originalIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
                        ImageIcon icon = new ImageIcon(scaledImage);

                        // Add images with label
                        JLabel coinLabel = new JLabel(denom.name(), icon, JLabel.CENTER);
                        coinLabel.setHorizontalTextPosition(JLabel.CENTER);
                        coinLabel.setVerticalTextPosition(JLabel.BOTTOM);
                        changePanel.add(coinLabel);
                    }

                    PurseDisplay display = new PurseCount(purse);
                    outputArea.setText(display.display()); // Add coin counts

                    String logEntry = "Change for $" + amount + ":\n" + display.display();
                    historyPanel.appendEntry(logEntry);   // Add history for each transaction


                });

                // Refresh Panel
                changePanel.revalidate();
                changePanel.repaint();


            } catch (NumberFormatException ex) {
                // Check for invalid input
                JOptionPane.showMessageDialog(RegisterPanel.this, "Please enter a valid number.");
            }
        }
    }

}
