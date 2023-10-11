package game;

import global.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class GameScreen extends JFrame{

	static ImagePanel panel = new ImagePanel("../image/GameFrame.png");




	public GameScreen() {
		int Num=1;
		int Count=5;
		JLabel count_label=new JLabel(" "+Count);
		JLabel number=new JLabel("No."+Num);

		count_label.setFont(new Font("Arial",Font.BOLD ,30));
		count_label.setBounds(1060,602,50,50);

		number.setFont(new Font("Arial",Font.BOLD ,30));
		number.setBounds(100,580,100,100);

		JProgressBar progressBar=new JProgressBar(JProgressBar.HORIZONTAL,0,100);
		progressBar.setBounds(300,610,650,30);
		panel.add(progressBar);

		setTitle("이상한 그림 찾기");
		setSize(1209,738);

		panel.add(count_label);
		panel.add(number);
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