package start;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class StartPage extends JPanel {
	
	Image img = new ImageIcon(StartPage.class.getResource("../image/startpageimage.png")).getImage();
			
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		setOpaque(false);
	}
	
	StartButton startBtn;
	ExplainButton explainBtn;
	
	public StartPage() {
		setLayout(null);
		startBtn = new StartButton();
		startBtn.setVisible(true);
		startBtn.setBounds(190, 486, 348, 105);
		
		explainBtn = new ExplainButton();
		explainBtn.setBounds(642, 486, 367, 105);
		
		add(startBtn);
		add(explainBtn);
	}
}