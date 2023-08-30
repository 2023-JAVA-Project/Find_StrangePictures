package main;

import javax.swing.JFrame;
import javax.swing.JPanel;

import game.GameScreen;
import tutorial.Tutorial;

public class Frame extends JFrame{
	public static JPanel current_panel;	
	
	public Frame() {
		setSize(1209,738);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String args[]) {
		Frame frame=new Frame();
		GameScreen game=new GameScreen();
		Tutorial tu=new Tutorial();
		//current_panel=game;
		frame.add(current_panel);
		frame.setVisible(true);
		
	}

}
