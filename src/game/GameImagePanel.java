package game;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.ArrayList;

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

        // 터치클릭 패널 기본 설정
        for(int i = 0; i < touchLabel.length; i++){
            touchLabel[i] = new JLabel();
            touchLabel[i].setLayout(null);
            touchLabel[i].setOpaque(true); // 투명하게 만드는 메서드
            touchLabel[i].setBackground(Color.red);
            touchLabel[i].setVisible(true);

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