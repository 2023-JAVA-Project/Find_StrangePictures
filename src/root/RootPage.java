package root;

import game.GamePage;
import score.ScorePage;

import javax.swing.*;
import java.awt.*;

public class RootPage extends JFrame {
		public static JPanel  pageNow;


		private static JPanel cardPanel;
		private static CardLayout cardLayout;

		private static GamePage gamePage;
		private static ScorePage scorePage;

		public RootPage() {

			setTitle("자꾸만 하고싶은 이상한 그림 찾기");
			setSize(1209,738);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			// CardLayout 설정
			cardPanel = new JPanel();
			cardLayout = new CardLayout();
			cardPanel.setLayout(cardLayout);

			// GamePage와 ScorePage 생성
			gamePage = new GamePage(this);


			scorePage = new ScorePage();

			// CardLayout에 페이지 추가
			cardPanel.add(gamePage, "GamePage");
			cardPanel.add(scorePage, "ScorePage");

			// RootPage에 CardLayout 패널 추가
			// CardLayout은 바탕이 되는 패널이다
			add(cardPanel);

		}

		public static void main(String[] args) {
			RootPage fr = new RootPage();




	//			StartPage startP = new StartPage();
	//			NamePage nameP = new NamePage();
	//			Tutorial tutorialP = new Tutorial();
	//			GamePage gameP = new GamePage();
	//			ScorePage scoreP = new ScorePage();
	//			pageNow = startP;
	//			fr.add(gameP); // TODO : startP로 바꾸기
	//
	//			startP.startBtn.addActionListener(new ActionListener() {
	//				@Override
	//				public void actionPerformed(ActionEvent e) {
	//					fr.setPage(gameP);
	//				}
	//			});
	//			startP.explainBtn.addActionListener(new ActionListener() {
	//				@Override
	//				public void actionPerformed(ActionEvent e) {
	//					//fr.add(tutorialP);
	//					fr.setPage(tutorialP);
	//				}
	//			});
	//			nameP.confirmBtn.addActionListener(new ActionListener() {
	//				@Override
	//				public void actionPerformed(ActionEvent e) {
	//					fr.setPage(scoreP);
	//				}
	//			});
	//
	//			if(GamePage.gameEnd == true) fr.setPage(scoreP);

			fr.setVisible(true);
		}

		// 게임 페이지로 전환하는 메서드
		public void showGamePage() {
			cardLayout.show(cardPanel, "GamePage");
		}

		// ScorePage로 전환하는 메서드
		public static void showScorePage() {
			cardLayout.show(cardPanel, "ScorePage");
		}

//		public void setPage(JPanel newPage) {
//
//			this.remove(pageNow); // 이전의 JPanel을 제거
//			pageNow = newPage;
//			this.add(pageNow); // 새로운 JPanel을 추가
//			this.revalidate(); // JFrame을 다시 그리도록 요
//			this.repaint();
//		}
	}