package rank;

import global.Controller;
import global.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class RankPage extends JPanel {
    int rankNum = 1;
    static ImagePanel panel = new ImagePanel("../image/rankPage.png");

    public RankPage() {
        panel.setLayout(null);
        panel.setBounds(0, 0, 1209, 738);

        Controller read = new Controller();
        JLabel[] nameLabels = new JLabel[5];
        JLabel[] scoreLabels = new JLabel[5];

        // 랭킹 라벨 증가
        int y = 280;
        for (int i = 0; i < 5; i++) {
            JLabel rank_num = new JLabel("" + rankNum);
            rank_num.setFont(new Font("Arial", Font.BOLD, 30));
            rank_num.setBounds(300, y, 200, 30);
            add(rank_num);
            rankNum++;

            nameLabels[i] = new JLabel();
            nameLabels[i].setFont(new Font("NanumGothic", Font.BOLD, 30));
            nameLabels[i].setBounds(560, y, 200, 30);
            add(nameLabels[i]);

            scoreLabels[i] = new JLabel(); // Create score label
            scoreLabels[i].setFont(new Font("Arial", Font.BOLD, 30));
            scoreLabels[i].setBounds(860, y, 200, 30);
            add(scoreLabels[i]);
            y += 85;
        }

        read.readData(nameLabels, scoreLabels);

        setLayout(null);
        panel.setVisible(true);
        add(panel);
    }
}
