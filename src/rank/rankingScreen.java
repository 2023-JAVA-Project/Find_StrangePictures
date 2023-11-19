package rank;

import global.Controller;
import global.ImagePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class rankingScreen extends JFrame {
    int rankNum=1;
    static ImagePanel panel = new ImagePanel("../image/rankPage.png");
    public rankingScreen(){
        
        setTitle("이상한 그림 찾기");
        setSize(1209,738);
        panel.setLayout(null);
        panel.setBounds(0,0,1209,738);

        Controller read=new Controller();
        JLabel[] nameLabels = new JLabel[5];
        JLabel[] scoreLabels = new JLabel[5];

        //랭킹 라벨 증가
        int y=280;
        for(int i=0;i<5;i++){
            JLabel rank_num=new JLabel(""+rankNum);
            rank_num.setFont(new Font("Arial",Font.BOLD,30));
            rank_num.setBounds(300,y,200,30);
            add(rank_num);
            rankNum++;

            nameLabels[i] = new JLabel(); // Create name label
            nameLabels[i].setFont(new Font("NanumGothic", Font.BOLD, 30));
            nameLabels[i].setBounds(560, y, 200, 30);
            panel.add(nameLabels[i]);

            scoreLabels[i] = new JLabel(); // Create score label
            scoreLabels[i].setFont(new Font("Arial", Font.BOLD, 30));
            scoreLabels[i].setBounds(860, y, 200, 30);
            panel.add(scoreLabels[i]);
            y+=85;
        }

        read.readData(nameLabels, scoreLabels);
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
