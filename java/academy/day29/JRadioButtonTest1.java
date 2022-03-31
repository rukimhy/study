package academy.day29;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

class JRadiobutton1 extends JFrame implements ActionListener {
	JLabel jl;
	JRadioButton[] jr = new JRadioButton[5];
	String[] hobby = { "�ȱ�", "���", "����", "��Ų������", "�䷯�۶��̵�" };

	public JRadiobutton1() {
		jl = new JLabel();
		JLabel jl1 = new JLabel("����� ��̴�?");
		JLabel jl2 = new JLabel("����� ���̴�?");
		JCheckBox[] jc = new JCheckBox[5];
		String[] age = { "20��", "30��", "40��", "50��", "60��" };
		JPanel hobbypanel = new JPanel();
		JPanel agepanel = new JPanel();
		ButtonGroup gb = new ButtonGroup();
		for (int i = 0; i < age.length; i++) {
			jr[i] = new JRadioButton(hobby[i]);
			jc[i] = new JCheckBox(age[i]);
			hobbypanel.add(jr[i]);
			agepanel.add(jc[i]);
			jc[i].addActionListener(this);
			gb.add(jc[i]);
		}
		Container ct = getContentPane();
		ct.setLayout(new GridLayout(3, 1));
		JPanel jp1 = new JPanel();
		jp1.add(jl1);
		jp1.add(hobbypanel);

		JPanel jp2 = new JPanel();
		jp2.add(jl2);
		jp2.add(agepanel);

		JPanel jp3 = new JPanel();
		jp3.add(jl);

		ct.add(jp1);
		ct.add(jp2);
		ct.add(jp3);
		setTitle("JRadioButtonTest1");
		setSize(350, 300);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		String s = "����� ��� : ";
		for (int i = 0; i < hobby.length; i++) {
			if (jr[i].isSelected() == true) {
				s = s + hobby[i] + " ";
			}
		}
		s = s + "����� ���� : ";
		jl.setText(s + ae.getActionCommand());
	}
}

public class JRadioButtonTest1 {

	public static void main(String[] args) {
		new JRadiobutton1();
	}

}
