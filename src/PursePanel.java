import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {

    private Purse.purse purse = new Purse.purse();

    public void setPurse(Purse.purse purse) {
        this.purse = purse;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        int x = 10;  // Start X position
        int y = 10;  // Start Y position
        int space = 5; // Space between images
        int lineHeight = 0; // Track the height of the current images

        // Loop through each denomination
        for (Map.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            // Load the image for 'x' denomination
            ImageIcon icon = new ImageIcon(denom.img());

            // Draw each coin/bill icon based on the count
            for (int i = 0; i < count; i++) {
                g.drawImage(icon.getImage(), x, y, this);
                x += icon.getIconWidth() + space;


                lineHeight = Math.max(lineHeight, icon.getIconHeight()); // Track the current height of the images
            }

            y += lineHeight + space;
            x = 10; // reset x position
        }
    }}
