package academy.day29;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

class JComboBox1 extends JFrame implements ItemListener {
	JLabel jl;
	JComboBox jcb;

	public JComboBox1() {
		jl = new JLabel();
		jcb = new JComboBox();
		String fr[] = { "permission", "banana", "pear", "apple", "cherry", "grape" };
		Container ct = getContentPane();
		ct.setLayout(new FlowLayout());
		for (int i = 0; i < fr.length; i++) {
			jcb.addItem(fr[i]);
		}
		ct.add(jcb);
		ct.add(jl);
		jcb.addItemListener(this);
		setTitle("JComboBox Test1");
		setSize(200, 200);
		setVisible(true);
	}

	public void itemStateChanged(ItemEvent ie) {
		String fruit = jcb.getItemAt(jcb.getSelectedIndex()).toString();
		jl.setIcon(new ImageIcon("./" + fruit + ".jpg"));
	}
}

public class JComboBoxTest1 {

	public static void main(String[] args) {
		new JComboBox1();
	}

}
