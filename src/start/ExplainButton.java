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
	private Image img = new ImageIcon(ExplainButton.class.getResource("../img/explainbutton.png")).getImage();
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
        // 이미지를 버튼의 배경으로 그림
        g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
	}
	
	public ExplainButton() {
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // 마우스 변경
		
		addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	img = new ImageIcon(StartButton.class.getResource("../img/explainbuttonover.png")).getImage();
            	
            }

            @Override
            public void mouseExited(MouseEvent e) {
                img = new ImageIcon(StartButton.class.getResource("../img/explainbutton.png")).getImage();
            }
        });
	}
}
