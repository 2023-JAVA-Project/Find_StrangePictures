package game;

import global.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame{

	static ImagePanel panel = new ImagePanel("../image/GameFrame.png");




	public GameScreen() {
		int Num=5;
		JLabel label=new JLabel(" hi hello"+Num);
		label.setFont(new Font("Arial",Font.BOLD ,30));
		label.setBounds(1060,602,50,50);

		setTitle("이상한 그림 찾기");
		setSize(1209,738);

		panel.add(label);
		panel.setLayout(null);
		panel.setBounds(0,0,1200,700);
		add(panel);

		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GameScreen();
	}

}