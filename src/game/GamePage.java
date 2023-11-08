package game;

import global.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel{

	static Image img = new ImageIcon(GamePage.class.getResource("../image/GameFrame.png")).getImage();
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		setOpaque(false);
	}
	int Num=1;
	static int Count=5;
	Timer timerBar;
	Thread threadBar;
	int second=30;

	static JLabel count_label;

	int[][] labelLoc = {{0, 3, 55, 60, 100, 23, 280, 70, 460, 130},{1,2,3,4,5,6,7,8,9,10},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130}}; // 두번째 이미지부터 넣어야함 (7개만)

	public GamePage() {
		count_label=new JLabel(" "+Count);
		JLabel number=new JLabel("No."+Num);

		count_label.setFont(new Font("Arial",Font.BOLD ,30));
		count_label.setBounds(1060,602,50,50);

		number.setFont(new Font("Arial",Font.BOLD ,30));
		number.setBounds(100,575,100,100);
		number.setBounds(100,575,100,100);

		timerBar=new Timer(second);
		add(timerBar);
		threadBar = new Thread(timerBar);
		threadBar.start();

		// 틀린그림 이미지 Panel
		GameImagePanel gameImg = new GameImagePanel(labelLoc[0]);
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


		// 시간 다 되기 전까지
//		while(timerBar.getWidth() > 0) {
////			gameImg.touchLabel[i]=jk;
//			if(Count == 0) {
//				gameImg.uploadImage();
//				Count = 5; // 다시 5로 초기화
//			}
//
//			// 투명 label 다시 보이게 하기
//			for (int j = 0; j < gameImg.touchLabel.length; j++){ // 투명 label array 5개
//				gameImg.replaceTouchLabel(labelLoc[j]);
//				gameImg.touchLabel[j].setVisible(true);
//			}
//		}


		if(Count == 0) {
			gameImg.uploadImage();
			for (int j = 0; j < gameImg.touchLabel.length - 1; j++){ // 투명 label array 5개
				gameImg.replaceTouchLabel(labelLoc[j+1]);
				gameImg.touchLabel[j].setVisible(true);
			}
			Count = 5; // 다시 5로 초기화
		}
	}

	static public void updateCountLabel() {
		count_label.setText(" " + Count);
	}
}