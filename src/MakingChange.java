import javax.swing.*;
import java.awt.*;

public class MakingChange {

    public static void main(String[] args) {

        // Create JFrame
        JFrame frame = new JFrame("MakingChange");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create register panel
        RegisterPanel Panel = new RegisterPanel();
        Panel.setPreferredSize(new Dimension(100, 100));
        frame.getContentPane().add(Panel);

        // Pack the frame
        frame.pack();

        //Display the frame
        frame.setVisible(true);




    }

}
