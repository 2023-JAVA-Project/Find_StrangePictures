package start;

import javax.swing.*;
import java.awt.*;

public class StartPage extends JPanel {
	
	Image img = new ImageIcon(StartPage.class.getResource("../image/startpageimage.png")).getImage();
			
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		setOpaque(false);
	}
	
	StartButton startBtn;
	ExplainButton explainBtn;
	
	public StartPage() {
<<<<<<< HEAD
		setLayout(null); // 기본설정인 FlowLayout를 비활성화함
=======
		setLayout(null);
>>>>>>> 6156d705baac6588d0f4d051ee95c70023fccd20
		startBtn = new StartButton();
		startBtn.setVisible(true);
		startBtn.setBounds(190, 486, 348, 105);
		
		explainBtn = new ExplainButton();
		explainBtn.setBounds(642, 486, 367, 105);
		
		add(startBtn);
		add(explainBtn);
	}
}