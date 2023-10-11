package start;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ExplainButton extends JButton {
	private Image img = new ImageIcon(ExplainButton.class.getResource("../image/explainbutton.png")).getImage();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
	}
	
	public ExplainButton() {
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	img = new ImageIcon(StartButton.class.getResource("../image/explainbuttonover.png")).getImage();
            	
            }

            @Override
            public void mouseExited(MouseEvent e) {
                img = new ImageIcon(StartButton.class.getResource("../image/explainbutton.png")).getImage();
            }
        });
	}
}
