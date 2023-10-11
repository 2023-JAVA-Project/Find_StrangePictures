package start;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class NamePage extends JPanel {
	public static String uname;
	
	Image img = new ImageIcon(NamePage.class.getResource("../image/namepageimage.png")).getImage();
	Image conBtn = new ImageIcon(NamePage.class.getResource("../image/confirmbutton.png")).getImage();
	
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, null);
		setOpaque(false);
	}
	
	public NamePage() {
		setLayout(null);

		JLabel explainName = new JLabel("이름을 입력해주세요");
		explainName.setFont(new Font("맑은 고딕", Font.BOLD, 48));
		explainName.setBounds(300, 236, 600, 58);
		explainName.setHorizontalAlignment(JTextField.CENTER);

		//TODO : nameEdit
		JTextField nameEdit = new JTextField() {
			@Override
            public void setBorder(Border border) {}
		};
		nameEdit.setBounds(264, 313, 674, 140);
        nameEdit.setFont(new Font("맑은 고딕", Font.PLAIN, 90));
        nameEdit.setHorizontalAlignment(JTextField.CENTER);
        
        JButton confirmBtn = new JButton() {
            

            public void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0, null);
                setOpaque(false);
            }
        };
        
        confirmBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//RootPage.changePage(this);
            }
        });
        
        confirmBtn.setBounds(482, 499, 367, 105);
        confirmBtn.setBorderPainted(false);
        confirmBtn.setContentAreaFilled(false);
        confirmBtn.setFocusPainted(false);
        confirmBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // ���콺 ����
        
        confirmBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	conBtn = new ImageIcon(NamePage.class.getResource("../image/confirmbuttonover.png")).getImage();
            	
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	conBtn = new ImageIcon(NamePage.class.getResource("../image/confirmbutton.png")).getImage();
            }
        });
        
        
        add(explainName);
		add(nameEdit);
		add(confirmBtn);
	}
}