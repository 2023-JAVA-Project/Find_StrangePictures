package score;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tutorial.ImagePanel;

public class Scorepage extends JPanel{
	static ImagePanel score_panel=new ImagePanel("../image/score_page.png");
	
	public Scorepage() {
		Main();
	}
	public void Main() {
		Frmae(score_panel);
	}
	private void Frmae(ImagePanel score_panel2) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]) {
		new Scorepage();
	}
	
	
}
