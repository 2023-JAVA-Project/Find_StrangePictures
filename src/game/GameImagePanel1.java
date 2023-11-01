package game;

import global.ImagePanel;

import javax.swing.*;

public class GameImagePanel1 extends JPanel {
//    static ImagePanel imgPanel=new ImagePanel("../image/GameFrame.png");
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setBounds(0,0,1200,700);

        GameImagePanel1 imgPanel = new GameImagePanel1();
        f.add(imgPanel);
        f.setVisible(true);
    }
}