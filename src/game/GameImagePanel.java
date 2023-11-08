package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.net.URL;

import static game.GamePage.updateCountLabel;

public class GameImagePanel extends JPanel {
    Vector<URL> gameImgs = new Vector<>(8);
//    Image img = getIcon("../image/game/g1.png", 1541, 764).getImage();
    Image img = new ImageIcon(GameImagePanel.class.getResource("../image/game/g1.png")).getImage().getScaledInstance(900, 400, Image.SCALE_SMOOTH);
    static JLabel[] touchLabel = new JLabel[5];

    public GameImagePanel(int labelPosition[]) {
        setLayout(null);
        setBounds(150,140,900,400); // 패널 위치, 사이즈
        setBackground(Color.CYAN);

        for(int i = 0; i < gameImgs.size(); i++){
            gameImgs.add(GameImagePanel.class.getResource("../image/game/g1.png"));
//            gameImgs.add("../image/game/g" + (i + 2) + ".png");
//            gameImgs.add(new ImageIcon(GameScreen.class.getResource("../image/game/g"+(i+1)+".png")));
        }


        for(int i = 0; i < touchLabel.length; i++){
            touchLabel[i] = new JLabel();
            touchLabel[i].setLayout(null);
            touchLabel[i].setOpaque(true);
            touchLabel[i].setBackground(Color.red);
            touchLabel[i].setBounds(labelPosition[i * 2], labelPosition[i * 2 + 1], 100, 100);
//            touchLabel[i].setBounds(20, 20, 100, 100);
            touchLabel[i].setVisible(true);


            // 라벨을 터치 했을 때
            touchLabel[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
//                    GamePage.Count--;
//                    (JLabel)me.setVisible(false);

                    JLabel clickedLabel = (JLabel) me.getSource();
                    GamePage.Count--;
                    System.out.println(GamePage.Count);
                    updateCountLabel();
                    clickedLabel.setVisible(false);
                }
            });

            add(touchLabel[i]);
        }

        touchLabel[0].setBounds(labelPosition[0], labelPosition[1], 50, 50);
        touchLabel[1].setBounds(labelPosition[2], labelPosition[3], 50, 50);
        touchLabel[2].setBounds(labelPosition[4], labelPosition[5], 50, 50);
        touchLabel[3].setBounds(labelPosition[6], labelPosition[7], 50, 50);
        touchLabel[4].setBounds(labelPosition[8], labelPosition[9], 50, 50);
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

    int imgCnt = 0;

    public void uploadImage() {
        imgCnt++;
        if (imgCnt < gameImgs.size()) {
            img = new ImageIcon(gameImgs.get(imgCnt)).getImage().getScaledInstance(900, 400, Image.SCALE_SMOOTH);
            repaint(); // 패널을 다시 그리도록 요청
        }
    }
}