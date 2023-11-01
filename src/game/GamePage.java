package game;

import global.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class GamePage extends JPanel{

	static ImagePanel panel = new ImagePanel("../image/GameFrame.png");
	int Num=1;
	int Count=5;
	Timer timerBar;
	Thread threadBar;
	int second=30;

	int[][] labelLoc = {{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{1,2,3,4,5,6,7,8,9,10},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130},{0, 3, 55, 612, 100, 23, 280, 70, 460, 130}}; // 두번째 이미지부터 넣어야함 (7개만)

	public GamePage() {
		JLabel count_label=new JLabel(" "+Count);
		JLabel number=new JLabel("No."+Num);

		count_label.setFont(new Font("Arial",Font.BOLD ,30));
		count_label.setBounds(1060,602,50,50);

		number.setFont(new Font("Arial",Font.BOLD ,30));
		number.setBounds(100,575,100,100);
		number.setBounds(100,575,100,100);

		timerBar=new Timer(second);
		threadBar=new Thread(timerBar);
		threadBar.start();
		panel.add(timerBar);

		// 틀린그림 이미지 Panel
		GameImagePanel gameImg = new GameImagePanel();

		panel.add(count_label);
		panel.add(number);
		panel.add(gameImg);
		panel.setLayout(null);
		panel.setBounds(0,0,1209,738);
		add(panel);

		setVisible(true);

		// 시간 다 되기 전까지
		while(timerBar.getWidth() > 0) {
//			gameImg.touchLabel[i]=jk;
			if(Count == 0) {
				gameImg.uploadImage();
				Count = 5; // 다시 5로 초기화
			}

			// 투명 label 다시 보이게 하기
			for (int j = 0; j < gameImg.touchLabel.length; j++){ // 투명 label array 5개
				gameImg.replaceTouchLabel(labelLoc[j]);
				gameImg.touchLabel[j].setVisible(true);
			}
		}
	}
}