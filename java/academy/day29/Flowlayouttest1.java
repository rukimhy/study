package day29;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

class Flowlayout1 extends JFrame{
	public Flowlayout1() {
		Container ct = getContentPane();
		FlowLayout fl = new FlowLayout(FlowLayout.RIGHT, 10, 15);
		ct.setLayout(fl);
		for(int i = 1; i <= 15; i++) {
			ct.add(new JButton("¹öÆ°"+i));
		}
		setTitle("Flowlayout Test1");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}

public class Flowlayouttest1 {

	public static void main(String[] args) {
		new Flowlayout1();
	}

}
