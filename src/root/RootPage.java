package root;

import game.GamePage;
import rank.RankPage;
import score.ScorePage;
import start.NamePage;
import start.StartPage;
import tutorial.Tutorial;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootPage extends JFrame {
    public static JPanel pageNow;


    private static JPanel cardPanel;
    private static CardLayout cardLayout;

    private static StartPage startPage;
    private static Tutorial tutorialPage;
    private static NamePage namePage;
    private static GamePage gamePage;
    private static ScorePage scorePage;
    private static RankPage rankPage;

    public RootPage() {

        setTitle("자꾸만 하고싶은 이상한 그림 찾기");
        setSize(1209, 738);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // CardLayout 설정
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // 페이지 Panel들 생성
        startPage = new StartPage();
        tutorialPage = new Tutorial();
        namePage = new NamePage();
        gamePage = new GamePage(this);
        scorePage = new ScorePage();
        rankPage=new RankPage();

        // CardLayout에 페이지 추가
//        cardPanel.add(startPage, "StartPage");
//        cardPanel.add(tutorialPage, "TutorialPage");
//        cardPanel.add(namePage, "NamePage");
//        cardPanel.add(gamePage, "GamePage");
        cardPanel.add(scorePage, "ScorePage");
        cardPanel.add(rankPage, "RankPage");

        // RootPage에 CardLayout 패널 추가
        // CardLayout은 바탕이 되는 패널이다
        add(cardPanel);

    }

    public static void main(String[] args) {
        RootPage fr = new RootPage();

        startPage.startBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                GamePage.threadBar.start();
                fr.showGamePage();
            }
        });

        startPage.explainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //fr.add(tutorialP);
                fr.showTutorialPage();
            }
        });

        namePage.confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.showScorePage();
            }
        });

        scorePage.ranking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.showRankPage();
            }
        });
        scorePage.restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.showStartPage();
            }
        });
        fr.setVisible(true);
    }

    public void showStartPage() {
        cardLayout.show(cardPanel, "StartPage");
    }

    public void showTutorialPage() {
        cardLayout.show(cardPanel, "TutorialPage");
    }

    public void showNamePage() {
        cardLayout.show(cardPanel, "NamePage");
    }


    // 게임 페이지로 전환하는 메서드
    public void showGamePage() {
        cardLayout.show(cardPanel, "GamePage");
    }


    // ScorePage로 전환하는 메서드
    public static void showScorePage() {
        cardLayout.show(cardPanel, "ScorePage");
    }

    public static void showRankPage() {
        cardLayout.show(cardPanel, "RankPage");
    }
}