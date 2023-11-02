package start;

import game.GamePage;
import tutorial.Tutorial;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootPage extends JFrame {
	public static JPanel  pageNow;
	
	public void setPage(JPanel newPage) {

		this.remove(pageNow); // 이전의 JPanel을 제거
	    pageNow = newPage;
	    this.add(pageNow); // 새로운 JPanel을 추가
	    this.revalidate(); // JFrame을 다시 그리도록 요
	    this.repaint();
	}
	
	public RootPage() {

		setTitle("자꾸만 하고싶은 이상한 그림 찾기");
		setSize(1209,738);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		RootPage fr = new RootPage();
				
		StartPage startP = new StartPage();
		NamePage nameP = new NamePage();
		Tutorial tutorialP=new Tutorial();
		GamePage gameP=new GamePage();
		pageNow = startP;
		fr.add(startP);

		startP.startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fr.setPage(nameP);
            }
        });
		startP.explainBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//fr.add(tutorialP);
				fr.setPage(tutorialP);
			}
		});
		nameP.confirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fr.setPage(gameP);
			}
		});

		fr.setVisible(true);
	}
}