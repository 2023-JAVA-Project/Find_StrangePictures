package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static game.GameImagePanel.replaceTouchLabel;
import static game.GameImagePanel.touchLabel;

import global.User;
import root.RootPage;

public class GamePage extends JPanel{

	static Image img = new ImageIcon(GamePage.class.getResource("../image/GameFrame.png")).getImage();
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		setOpaque(false);
	}
	int Num=1;
	static int Count=5;
	public static int Score = 0;

	public static int imgCnt = 0; // 몇 번째 이미지인지 나타냄

	public static boolean gameEnd = false;

	public static Timer timerBar;
	public static Thread threadBar;

	int second=30;

	static JLabel count_label;

	// 900,400
	int[][] labelLoc = {
			{555, 120, 744, 76, 670, 320, 690, 140, 464, 255}, // 1번 이미지 위치
			{800, 45, 690, 100, 700, 310, 450, 240, 490, 50}, // 2번 이미지 위치
			{690, 190, 800, 330, 540, 230, 635, 50, 840, 40}, // 3번
			{810, 350, 470, 340, 540, 270, 700, 210, 820, 110}, // 4번
			{840, 110, 730, 285, 565, 70, 630, 200, 642, 110}, // 5번
			{530, 330, 600, 263, 785, 300, 600, 90, 765, 170} // 6번
	}; // 두번째 이미지부터 넣어야함 (7개만)

	public GamePage(RootPage fr) {
		count_label=new JLabel(" "+Count);
		JLabel number=new JLabel("No."+Num);

		count_label.setFont(new Font("Arial",Font.BOLD ,30));
		count_label.setBounds(1060,602,50,50);

		number.setFont(new Font("Arial",Font.BOLD ,30));
		number.setBounds(100,575,100,100);

		timerBar=new Timer(second);
		add(timerBar);
		threadBar = new Thread(()  -> {
			timerBar.run();
			if (timerBar.isTimerFinished()) {
				SwingUtilities.invokeLater(() -> fr.showNamePage());
			}
		});



		// 틀린그림 이미지 Panel
		GameImagePanel gameImg = new GameImagePanel(labelLoc);
		replaceTouchLabel(labelLoc[0]);

		// 투명 패널 터치했을 때 이벤트 설정
		for(int i = 0; i < touchLabel.length; i++) {
			touchLabel[i].addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent me) {

					JLabel clickedLabel = (JLabel) me.getSource();
					Count--;
					Score += 10; // 점수 계산
//                  System.out.println(GamePage.Score);


					updateCountLabel(); // GamePage::화면에 Count 다시 씀

					clickedLabel.setVisible(false);

					// 다 찾으면
					if(Count == 0) {

						gameImg.uploadImage(); // 이미지 바꾸는 메서드
						GamePage.imgCnt++; // 몇 번째 이미지인지

						if (GamePage.imgCnt != 6) {
							replaceTouchLabel(labelLoc[GamePage.imgCnt]); // 터치라벨 재배치 시키는 메서드

//							System.out.println(imgCnt);

							for (int j = 0; j < touchLabel.length - 1; j++) { // 투명 label array 5개
								touchLabel[j].setVisible(true);
							}
							Count = 5; // 다시 5로 초기화
							updateCountLabel();
						}


						if(gameEnd == true) {
							fr.showNamePage();
							User.setScore(getScore());
						}
						setScore(Score);
					}

				}
			});

		}

		add(count_label);
		add(number);
		add(gameImg);
		setLayout(null);
		setBounds(0,0,1209,738);

		setLayout(null);
		setVisible(true);

		add(count_label);
		add(number);
		add(gameImg);
		setLayout(null);
		setBounds(0,0,1209,738);
		setVisible(true);


	}

	public int getScore() {
		return Score;
	}
	public void setScore(int newScore) {
		Score = newScore;
	}



	static public void updateCountLabel() {
		count_label.setText(" " + Count);
	}

}