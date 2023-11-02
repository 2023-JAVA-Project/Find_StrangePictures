package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;
import java.net.URL;

public class GameImagePanel extends JPanel {
    Vector<URL> gameImgs = new Vector<>(8);
//    Image img = getIcon("../image/game/g1.png", 1541, 764).getImage();
    Image img = new ImageIcon(GameImagePanel.class.getResource("../image/game/g1.png")).getImage().getScaledInstance(900, 400, Image.SCALE_SMOOTH);
    static JLabel[] touchLabel = new JLabel[5];

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public GameImagePanel() {
        for(int i = 0; i < gameImgs.size(); i++){
            gameImgs.add(GameImagePanel.class.getResource("../image/game/g1.png"));
//            gameImgs.add("../image/game/g" + (i + 2) + ".png");
//            gameImgs.add(new ImageIcon(GameScreen.class.getResource("../image/game/g"+(i+1)+".png")));
        }

        for(int i = 0; i < touchLabel.length; i++){
            touchLabel[i] = new JLabel();
            touchLabel[i].setLayout(null);
            touchLabel[i].setBackground(Color.red);
            touchLabel[i].addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent me) {
//                    GameScreen.Count--;
                    setVisible(false);
                }
            });
        }
        setLayout(null);
        setBounds(150,140,900,400); // 패널 위치, 사이즈
        setBackground(Color.CYAN);
    }

    public static void replaceTouchLabel(int[] a) {
        touchLabel[0].setBounds(a[0], a[1], 50, 50);
        touchLabel[1].setBounds(a[2], a[3], 50, 50);
        touchLabel[2].setBounds(a[4], a[5], 50, 50);
        touchLabel[3].setBounds(a[6], a[7], 50, 50);
        touchLabel[4].setBounds(a[8], a[9], 50, 50);
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