package start;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RootPage extends JFrame {
	public static JPanel  pageNow;
	
	public void setPage(JPanel newPage) {
		this.remove(pageNow); // ������ JPanel�� ����
	    pageNow = newPage;
	    this.add(pageNow); // ���ο� JPanel�� �߰�
	    this.revalidate(); // JFrame�� �ٽ� �׸����� ��û
	    this.repaint();
	}
	
	public RootPage() {
		setTitle("�̻��� �׸� ã��");
		setSize(1209,738);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		RootPage fr = new RootPage();
				
		StartPage startP = new StartPage();
		NamePage nameP = new NamePage();
		pageNow = startP;
		fr.add(startP);
		
		// ����ȭ�� - ���� ��ư
		startP.startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	fr.setPage(nameP);
            }
        });
		
		
		
		fr.setVisible(true);
	}
}