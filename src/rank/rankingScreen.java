package rank;

import global.Controller;
import global.ImagePanel;

import javax.swing.*;

public class rankingScreen extends JFrame {
    static ImagePanel panel = new ImagePanel("../image/rankPage.png");
    public rankingScreen(){



        setTitle("이상한 그림 찾기");
        setSize(1209,738);
        Controller dao=new Controller();

        
        dao.readData();
        panel.setLayout(null);
        panel.setBounds(0,0,1209,738);
        add(panel);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new rankingScreen();
    }
}
