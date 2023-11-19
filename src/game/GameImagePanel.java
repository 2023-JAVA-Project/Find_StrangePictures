package game;

import score.ScorePage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.net.URL;

import static game.GamePage.gameEnd;
import static game.GamePage.updateCountLabel;

public class GameImagePanel extends JPanel {
    ArrayList<URL> gameImgs = new ArrayList<>(6);

    Image img = new ImageIcon(GameImagePanel.class.getResource("../image/game/g1.png")).getImage().getScaledInstance(900, 400, Image.SCALE_SMOOTH);
    static JLabel[] touchLabel = new JLabel[5];



    public GameImagePanel(int labelPosition[][]) {
        setLayout(null);
        setBounds(150,140,900,400); // 패널 위치, 사이즈
        setBackground(Color.CYAN);

        // ArrayList에 이미지 add
        for(int i = 0; i < 6; i++){
            gameImgs.add(GameImagePanel.class.getResource("../image/game/g"+(i+1)+".png"));
        }

        // 터치클릭 패널
        for(int i = 0; i < touchLabel.length; i++){
            touchLabel[i] = new JLabel();
            touchLabel[i].setLayout(null);
            touchLabel[i].setOpaque(true); // 투명하게 만드는 메서드
            touchLabel[i].setBackground(Color.red);
            touchLabel[i].setVisible(true);


            // 라벨을 터치 했을 때
            touchLabel[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {

                    JLabel clickedLabel = (JLabel) me.getSource();
                    GamePage.Count--;
                    GamePage.Score += 10;

//                    System.out.println(GamePage.Score);

                    updateCountLabel(); // GamePage::화면에 Count 다시 씀

                    clickedLabel.setVisible(false);

                    // 다 찾으면
                    if(GamePage.Count == 0) {

                        uploadImage(); // 이미지 바꾸는 메서드
                        GamePage.imgCnt++; // 몇 번째 이미지인지

                        if (GamePage.imgCnt != 6) {
                            replaceTouchLabel(labelPosition[GamePage.imgCnt]); // 터치라벨 재배치 시키는 메서드

                            System.out.println(GamePage.imgCnt);

                            for (int j = 0; j < touchLabel.length - 1; j++) { // 투명 label array 5개
//                            replaceTouchLabel(labelPosition[j+1]);
                                touchLabel[j].setVisible(true);
                            }
                            GamePage.Count = 5; // 다시 5로 초기화
                            updateCountLabel();
                        }

                        if(GamePage.gameEnd == true) {

                        }

                    }
                }
            });

            add(touchLabel[i]);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public static void replaceTouchLabel(int[] a) {
        touchLabel[0].setBounds(a[0], a[1], 50, 50);
        touchLabel[1].setBounds(a[2], a[3], 50, 50);
        touchLabel[2].setBounds(a[4], a[5], 50, 50);
        touchLabel[3].setBounds(a[6], a[7], 50, 50);
        touchLabel[4].setBounds(a[8], a[9], 50, 50);

        for(int i = 0; i < touchLabel.length; i++) {
            touchLabel[i].setVisible(true);
        }
    }

    public void uploadImage() {
        if (GamePage.imgCnt+1 < gameImgs.size()) {
            img = new ImageIcon(gameImgs.get(GamePage.imgCnt+1)).getImage().getScaledInstance(900, 400, Image.SCALE_SMOOTH);
            repaint(); // 패널을 다시 그리도록 요청
        } else {
            GamePage.gameEnd = true;
//            System.out.println(gameEnd);
        }
    }
}