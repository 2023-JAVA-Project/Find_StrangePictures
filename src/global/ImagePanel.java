package global;

import tutorial.Tutorial;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	private Image background;

	public ImagePanel(String imagePath) {
		background=new ImageIcon(Tutorial.class.getResource(imagePath)).getImage();
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(background,0,0,null);
	}
}
