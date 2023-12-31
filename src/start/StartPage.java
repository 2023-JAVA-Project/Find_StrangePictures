package start;

import javax.swing.*;
import java.awt.*;

public class StartPage extends JPanel {
	
	Image img = new ImageIcon(StartPage.class.getResource("../image/startpageimage.png")).getImage();
			
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		setOpaque(false);
	}
	
	public StartButton startBtn;
	public ExplainButton explainBtn;
	
	public StartPage() {
		setLayout(null); // 기본설정인 FlowLayout를 비활성화함
		startBtn = new StartButton();
		startBtn.setVisible(true);
		startBtn.setBounds(190, 486, 348, 105);
		
		explainBtn = new ExplainButton();
		explainBtn.setBounds(642, 486, 367, 105);
		
		add(startBtn);
		add(explainBtn);
	}
}