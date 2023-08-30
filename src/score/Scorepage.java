package score;

import javax.swing.JFrame;

import tutorial.ImagePanel;

public class Scorepage extends JFrame{
	static ImagePanel score_panel=new ImagePanel("../image/score_page.png");
	
	public Scorepage() {
		Main();
	}
	public void Main() {
		score_panel.setLayout(null);
		score_panel.setBounds(0,0,1209,738);
		
		add(score_panel);
		setSize(1209,738);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]) {
		new Scorepage();
	}
	
	
}
