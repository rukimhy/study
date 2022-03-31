package academy.day29;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

class FirstFrame1 {
	public FirstFrame1() {
		JFrame jf = new JFrame("ù ��° GUI ���α׷�"); // ������ ��ü ���� (���� ����)
		Container ct = jf.getContentPane(); // ���������κ��� �����̳� ����
		JButton jb = new JButton("�׽�Ʈ��ư"); // ��ư ������Ʈ ����
		ct.add(jb); // ��ư�� �����̳ʿ� �߰�
		jf.setSize(400, 300); // ������ ũ�� ����
		jf.setVisible(true); // �������� ȭ�鿡 ���
	}
}

public class Frametest1and2 {

	public static void main(String[] args) {
		new FirstFrame1();
	}

}
