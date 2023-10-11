package tutorial;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import global.ImagePanel;

public class Tutorial extends JFrame{
	static ImagePanel panel1=new ImagePanel("../image/Tutorial1.png");
	static ImagePanel panel2=new ImagePanel("../image/Tutorial2.png");
	static ImagePanel panel3=new ImagePanel("../image/Tutorial3.png");
	static ImagePanel panel4=new ImagePanel("../image/Tutorial4.png");
	
	public Tutorial() {
		setTitle("이상한 그림 찾기");
		panel1.setLayout(null);
		panel1.setBounds(0,0,1209,738);
		panel2.setLayout(null);
		panel2.setBounds(0,0,1209,738);
		panel3.setLayout(null);
		panel3.setBounds(0,0,1209,738);
		panel4.setLayout(null);
		panel4.setBounds(0,0,1209,738);
		panel1.setOpaque(false);

		ImageIcon change_next = new ImageIcon(Tutorial.class.getResource("../image/change_next.png"));
		JButton change_nextbtn=new JButton(change_next);
		change_nextbtn.setLayout(null);
		change_nextbtn.setBounds(100,310,80,80);
		
		ImageIcon change_before= new ImageIcon(Tutorial.class.getResource("../image/change_before.png"));
		JButton change_beforebtn=new JButton(change_before);
		change_beforebtn.setLayout(null);
		change_beforebtn.setBounds(100,310,80,80);
		
		JLabel tutorial1=new JLabel("<html> &nbsp &nbsp 비슷한 두개의 사진을 비교하여 <br> 오른쪽 그림에서 틀린 곳을 선택하시오!</html>");
		tutorial1.setBounds(400,550,1000,100);
		Font font=new Font("맑은 고딕",Font.BOLD,25);
		tutorial1.setFont(font);
		panel1.add(tutorial1);
		
		JLabel tutorial2=new JLabel("정해진 시간안에 틀린 곳을 찾으시오!");
		tutorial2.setBounds(400,550,1000,100);
		tutorial2.setFont(font);
		panel2.add(tutorial2);	
		
		JLabel tutorial3=new JLabel("몇 개를 더 찾아야하는지 확인하시오!");
		tutorial3.setBounds(400,550,1000,100);
		tutorial3.setFont(font);
		panel3.add(tutorial3);
		
		JLabel tutorial4=new JLabel("<html>다른 부분이 아닌 곳을 건드리면 하트가 줄어듭니다!<br>&nbsp 하트가 모두 소진되면 게임종료!</html>");
		tutorial4.setBounds(400,550,1000,100);
		tutorial4.setFont(font);
		panel4.add(tutorial4);
		
		ImageIcon next_icon = new ImageIcon(Tutorial.class.getResource("../image/next_btn.png"));
		ImageIcon before_icon = new ImageIcon(Tutorial.class.getResource("../image/before_btn.png"));
		
		JButton panel1_next = new JButton(next_icon);
		panel1_next.setBounds(1070,310,80,80);
		panel1_next.setBorderPainted(false);
		panel1_next.setContentAreaFilled(false);
		panel1_next.setFocusPainted(false);
		panel1.add(panel1_next);
		
		JButton panel2_next=new JButton(next_icon);
		panel2_next.setLayout(null);
		panel2_next.setBounds(1070,310,80,80);
		JButton panel2_before=new JButton(before_icon);
		panel2_before.setLayout(null);
		panel2_before.setBounds(100,310,80,80);
		panel2_next.setBorderPainted(false);
		panel2_next.setContentAreaFilled(false);
		panel2_next.setFocusPainted(false);
		panel2_before.setBorderPainted(false);
		panel2_before.setContentAreaFilled(false);
		panel2_before.setFocusPainted(false);
		panel2.add(panel2_next);
		panel2.add(panel2_before);
		
		JButton panel3_next=new JButton(next_icon);
		panel3_next.setLayout(null);
		panel3_next.setBounds(1070,310,80,80);
		JButton panel3_before=new JButton(before_icon);
		panel3_before.setLayout(null);
		panel3_before.setBounds(100,310,80,80);
		panel3_next.setBorderPainted(false);
		panel3_next.setContentAreaFilled(false);
		panel3_next.setFocusPainted(false);
		panel3_before.setBorderPainted(false);
		panel3_before.setContentAreaFilled(false);
		panel3_before.setFocusPainted(false);
		panel3.add(panel3_next);
		panel3.add(panel3_before);
		
		JButton panel4_before=new JButton(before_icon);
		panel4_before.setLayout(null);
		panel4_before.setBounds(100,310,80,80);
		panel4_before.setBorderPainted(false);
		panel4_before.setContentAreaFilled(false);
		panel4_before.setFocusPainted(false);
		panel4.add(panel4_before);
		
		panel1_next.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel2_next.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel2_before.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel3_next.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel3_before.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel4_before.setCursor(new Cursor(Cursor.HAND_CURSOR));
	
		panel1_next.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // TODO Auto-generated method stub
		        panel1.setVisible(false);
		        add(panel2);
		        panel2.setVisible(true);
		    }
		});

		panel1_next.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        panel1_next.setIcon(change_next); // 마우스를 버튼 위로 올렸을 때 이미지 변경
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        panel1_next.setIcon(next_icon); // 마우스가 버튼을 벗어났을 때 이미지 복원
		    }
		});
		
		panel2_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel2.setVisible(false);
				add(panel3);
				panel3.setVisible(true);
			}
		});
		panel2_next.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        panel2_next.setIcon(change_next); // 마우스를 버튼 위로 올렸을 때 이미지 변경
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        panel2_next.setIcon(next_icon); // 마우스가 버튼을 벗어났을 때 이미지 복원
		    }
		});
		panel2_before.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel2.setVisible(false);
				add(panel1);
				panel1.setVisible(true);
			}
		});
		panel2_before.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	panel2_before.setIcon(change_before); // 마우스를 버튼 위로 올렸을 때 이미지 변경
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel2_before.setIcon(before_icon); // 마우스가 버튼을 벗어났을 때 이미지 복원
		    }
		});
		panel3_next.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel3.setVisible(false);
				add(panel4);
				panel4.setVisible(true);
			}
		});
		panel3_next.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	panel3_next.setIcon(change_next); // 마우스를 버튼 위로 올렸을 때 이미지 변경
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel3_next.setIcon(next_icon); // 마우스가 버튼을 벗어났을 때 이미지 복원
		    }
		});
		panel3_before.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel3.setVisible(false);
				add(panel2);
				panel2.setVisible(true);
			}
		});
		panel3_before.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	panel3_before.setIcon(change_before); // 마우스를 버튼 위로 올렸을 때 이미지 변경
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel3_before.setIcon(before_icon); // 마우스가 버튼을 벗어났을 때 이미지 복원
		    }
		});
		panel4_before.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel4.setVisible(false);
				add(panel3);
				panel3.setVisible(true);
			}
			
		});
		panel4_before.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	panel4_before.setIcon(change_before); // 마우스를 버튼 위로 올렸을 때 이미지 변경
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	panel4_before.setIcon(before_icon); // 마우스가 버튼을 벗어났을 때 이미지 복원
		    }
		});
		add(panel1);
		setSize(1209,738);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
