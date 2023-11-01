package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class GameImagePanel extends JPanel {
    Vector<ImageIcon> gameImgs = new Vector<>(8);
//    Image img = getIcon("../image/game/g1.png", 1541, 764).getImage();
//    Image img = new ImageIcon(GameScreen.class.getResource("../image/game/g1.png")).getImage();
    Image img = Toolkit.getDefaultToolkit().getImage("../image/game/g1.png").getScaledInstance(1541, 764, Image.SCALE_SMOOTH);
    static JLabel[] touchLabel = new JLabel[5];

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }

    public GameImagePanel() {
        for(int i = 0; i < gameImgs.size(); i++){
            gameImgs.add(getIcon("../image/image/g" + (i + 1) + ".png", 1541, 764));
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
        setBounds(0,0,1000,500);
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
        if (imgCnt < gameImgs.size()) {
            img = gameImgs.get(imgCnt).getImage();
            repaint(); // 패널을 다시 그리도록 요청
        }
        imgCnt++;
    }

    public static ImageIcon getIcon(String path, int w, int h) {
        return new ImageIcon(Toolkit.getDefaultToolkit().getImage(path).getScaledInstance(w, h, Image.SCALE_SMOOTH));
    }
}