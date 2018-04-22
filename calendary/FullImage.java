package calendary;

import java.awt.*;

import javax.swing.*;

public class FullImage extends JFrame {
    public FullImage() {
        JPanel p = new JPanel() {
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon ii = new ImageIcon("1.jpg");
                g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
            }
        };
        setVisible(true);
    }
}
