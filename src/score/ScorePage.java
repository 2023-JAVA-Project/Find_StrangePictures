package score;

import javax.swing.*;

import game.GamePage;
import global.ImagePanel;
import global.User;
import tutorial.Tutorial;

import java.awt.*;
import java.sql.*;

public class ScorePage extends JPanel {
    static ImagePanel score_panel = new ImagePanel("../image/score_page.png");
    public static JButton restart;
    public static JButton ranking;
    static JLabel scoreLabel;

    public GamePage gamePage;

    public ScorePage() {
        score_panel.setLayout(null);
        score_panel.setBounds(0, 0, 1209, 738);

        ImageIcon restart_icon = new ImageIcon(Tutorial.class.getResource("../image/restart_btn.png"));
        ImageIcon ranking_icon = new ImageIcon(Tutorial.class.getResource("../image/ranking_view_btn.png"));

        restart = new JButton(restart_icon);
        ranking = new JButton(ranking_icon);

        try {
            ResultSet rs = CommonFrame.getResult("select * from java_db.rank ORDER BY id DESC");
            rs.next();
            scoreLabel = new JLabel("" + rs.getInt("score"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        scoreLabel.setFont(new Font("Arial", Font.BOLD, 200));
        scoreLabel.setBounds(450, 100, 500, 500);

        restart.setLayout(null);
        restart.setBounds(200, 520, 300, 100);
        restart.setBorderPainted(false);
        restart.setContentAreaFilled(false);
        restart.setFocusPainted(false);


        ranking.setLayout(null);
        ranking.setBounds(650, 520, 300, 100);
        ranking.setBorderPainted(false);
        ranking.setContentAreaFilled(false);
        ranking.setFocusPainted(false);

        score_panel.add(scoreLabel);
        score_panel.add(restart);
        score_panel.add(ranking);
        add(score_panel);


        setSize(1209, 738);
        setLayout(null);
        setVisible(true);
    }

}
