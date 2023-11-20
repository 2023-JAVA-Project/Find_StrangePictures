package start;

import javax.swing.*;
import java.awt.*;

public class Test extends JFrame {
    public Test() {

        setTitle("자꾸만 하고싶은 이상한 그림 찾기");
        setSize(1209,738);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        Test fr=new Test();
        fr.setVisible(true);
    }
}
