import javax.swing.*;
import java.awt.*;

    public class HistoryPanel extends JPanel {
        private final JTextArea historyArea = new JTextArea(15, 30);  // Text are for history log

        public HistoryPanel() {
            setLayout(new BorderLayout());
            historyArea.setFont(new Font("Monospaced", Font.PLAIN, 14));  // Formatting
            JScrollPane scrollPane = new JScrollPane(historyArea);   // Scrollpane for are
            setBorder(BorderFactory.createTitledBorder("Register History"));   // Title for scrollpane
            add(scrollPane, BorderLayout.CENTER);    // Add scrollpane to panel
        }

        public void appendEntry(String entry) {
            historyArea.append(entry + "\n\n");    // Add spaces between entries
        }
    }


