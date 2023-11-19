package score;

import javax.swing.*;

import global.ImagePanel;
import tutorial.Tutorial;

public class ScorePage extends JPanel {
	static ImagePanel score_panel=new ImagePanel("../image/score_page.png");
	
	public ScorePage() {
		
		score_panel.setLayout(null);
		score_panel.setBounds(0,0,1209,738);
		
		ImageIcon restart_icon = new ImageIcon(Tutorial.class.getResource("../image/restart_btn.png"));
		ImageIcon ranking_icon = new ImageIcon(Tutorial.class.getResource("../image/ranking_view_btn.png"));
		
		JButton restart=new JButton(restart_icon);
		JButton ranking=new JButton(ranking_icon);
		
		restart.setLayout(null);
		restart.setBounds(200,520,300,100);
		restart.setBorderPainted(false);
		restart.setContentAreaFilled(false);
		restart.setFocusPainted(false);
		
		ranking.setLayout(null);
		ranking.setBounds(650,520,300,100);
		ranking.setBorderPainted(false);
		ranking.setContentAreaFilled(false);
		ranking.setFocusPainted(false);
		
		score_panel.add(restart);
		score_panel.add(ranking);
		add(score_panel);

		
		setSize(1209,738);
		setLayout(null);
		setVisible(true);
	}

//	public static void main(String[] args) {
//		ScorePage s = new ScorePage();
//
//		s.setVisible(true);
//	}

}
