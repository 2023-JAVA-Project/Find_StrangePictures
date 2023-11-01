package game;

import global.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel{

	static ImagePanel panel = new ImagePanel("../image/GameFrame.png");
	int Num=1;
	int Count=5;
	Timer timerBar;
	Thread threadBar;
	int second=30;

	public GamePage() {

		JLabel count_label=new JLabel(" "+Count);
		JLabel number=new JLabel("No."+Num);

		count_label.setFont(new Font("Arial",Font.BOLD ,30));
		count_label.setBounds(1060,602,50,50);

		number.setFont(new Font("Arial",Font.BOLD ,30));
		number.setBounds(100,575,100,100);
		number.setBounds(100,575,100,100);

		timerBar=new Timer(second);
		threadBar=new Thread(timerBar);
		threadBar.start();
		panel.add(timerBar);


		panel.add(count_label);
		panel.add(number);
		panel.setLayout(null);
		panel.setBounds(0,0,1209,738);
		add(panel);


		setLayout(null);
		panel.setVisible(true);
		add(panel);
	}

}