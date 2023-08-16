package game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameScreen extends JFrame{
	static JPanel panel=new JPanel() {
		Image background=new ImageIcon(GameScreen.class.getResource("../image/GameFrame.png")).getImage();
		public void paint(Graphics g) {//그리는 함수
				g.drawImage(background, 0, 0, null);//background를 그려줌		
		}
	};
	public GameScreen() {
		Main();
	}
	public void Main() {
		setTitle("이상한 그림 찾기");
		setSize(1209,738);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		panel.setLayout(null);
		panel.setBounds(0,0,1200,700);
		add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new GameScreen();
		
		
	}	

}
