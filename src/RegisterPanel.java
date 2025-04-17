import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPanel extends JPanel {

    private final Register register = new Register();
    private final JPanel registerPanel = new JPanel();
    private final JTextField input = new JTextField(10);
    private final PursePanel changePanel = new PursePanel();

    public RegisterPanel() {
        this.setBackground(Color.BLUE);

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
    }


    private class InputListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            try {
                // Parse the amount entered by the user
                double amount = Double.parseDouble(input.getText());

                // Get the purse with the change
                Purse.purse purse = register.makeChange(amount);

                // Clear previous images
                changePanel.removeAll();

                // Display Images
                purse.cash.forEach((denom, count) -> {
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
