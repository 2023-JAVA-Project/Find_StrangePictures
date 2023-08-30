package game;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tutorial.ImagePanel;

public class GameScreen extends JFrame{
	static ImagePanel game_panel=new ImagePanel("../image/GameFrame.png");
	public GameScreen() {
		game_panel.setLayout(null);
		game_panel.setBounds(0,0,1200,700);
		add(game_panel);
	}
}
