package academy.day29;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

class JScrollPane1 extends JFrame {
	public JScrollPane1() {
		Container ct = getContentPane();
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(20, 5));
		for (int i = 1; i <= 100; i++) {
			jp.add(new JButton(i + "��"));
		}
		int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
		JScrollPane jsp = new JScrollPane(jp, v, h);
		ct.add(jsp, BorderLayout.CENTER);
		setTitle("JScrollPane Test1");
		setSize(300, 300);
		setVisible(true);
	}
}

public class JScrollPanelTest1 {

	public static void main(String[] args) {
		new JScrollPane1();
	}

}
