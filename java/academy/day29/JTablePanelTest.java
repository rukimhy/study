package academy.day29;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;

class RadioPanel extends JPanel implements ActionListener {
	JLabel jl1 = new JLabel("����� ������?");
	JLabel jl2 = new JLabel(" ");

	public RadioPanel() {
		JRadioButton jrb1 = new JRadioButton("����");
		JRadioButton jrb2 = new JRadioButton("����");
		add(jl1);
		add(jl2);
		add(jrb1);
		add(jrb2);
		jrb1.addActionListener(this);
		jrb2.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String s = ae.getActionCommand();
		jl2.setText(s);
	}
}

class ComboPanel extends JPanel implements ItemListener {
	JLabel jl1 = new JLabel("����� ��������?");
	JLabel jl2 = new JLabel(" ");

	public ComboPanel() {
		JComboBox jcb = new JComboBox();
		jcb.addItem("A��");
		jcb.addItem("B��");
		jcb.addItem("O��");
		jcb.addItem("AB��");
		add(jl1);
		add(jl2);
		add(jcb);
		jcb.addItemListener(this);

	}

	public void itemStateChanged(ItemEvent ie) {
		Object s = ie.getItem();
		jl2.setText(s.toString());
	}
}

class JTabbedPane1 extends JFrame {
	public JTabbedPane1() {
		JTabbedPane jtp = new JTabbedPane();
		RadioPanel rp = new RadioPanel();
		ComboPanel cp = new ComboPanel();
		jtp.addTab("����", rp);
		jtp.addTab("������", cp);
		getContentPane().add(jtp);
		setTitle("JTabbedPaneTset1");
		setSize(500, 150);
		setVisible(true);
	}
}

public class JTablePanelTest {

	public static void main(String[] args) {
		new JTabbedPane1();
	}

}
