package rank;

import global.Controller;
import global.ImagePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class rankingScreen extends JFrame {
    static ImagePanel panel = new ImagePanel("../image/rankPage.png");
    public rankingScreen(){
        
        setTitle("이상한 그림 찾기");
        setSize(1209,738);
        panel.setLayout(null);
        panel.setBounds(0,0,1209,738);

        Controller read=new Controller();

        JTable table = new JTable();
        DefaultTableModel model =(DefaultTableModel) table.getModel(); ;

        model.addColumn("랭킹");
        model.addColumn("이름");
        model.addColumn("점수");

        table.setShowGrid(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(400,250, 500, 400);
        add(scrollPane);

        read.readData(model,10);
        add(panel);


        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new rankingScreen();
    }
}
