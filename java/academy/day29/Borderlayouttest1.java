package academy.day29;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

class BorderLayout1 extends JFrame {
	public BorderLayout1() {
		Container ct = getContentPane();
		BorderLayout bl = new BorderLayout(10, 10);
		ct.setLayout(bl);
		ct.add(new JButton("������ ��ư"), BorderLayout.EAST);
		ct.add(new JButton("���� ��ư"), BorderLayout.WEST);
		ct.add(new JButton("���� ��ư"), BorderLayout.NORTH);
		ct.add(new JButton("�Ʒ��� ��ư"), BorderLayout.SOUTH);
		ct.add(new JButton("�߾��� ��ư"), BorderLayout.CENTER);
		setTitle("BorderLayout Test1");
		setSize(400, 300);
		setVisible(true);
	}
}

public class Borderlayouttest1 {

	public static void main(String[] args) {
		new BorderLayout1();
	}

}
