package academy.day29;
//GUI ���ھ߱����� �����

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Game {
	int cpu[] = new int[3];
	int user[] = new int[] { 123, 124, 125 };
	int strike, ball;

	// cpu ���� ���� ����
	public void randomCpu() {
		Random r = new Random();

		while (true) {
			for (int i = 0; i < 3; i++) {
				cpu[i] = r.nextInt(9) + 1;
			}
			if (cpu[0] != cpu[1] && cpu[0] != cpu[2] && cpu[1] != cpu[2])
				break;
		}
	}

	// user 3�� �Է� ����
	public void input() {
		Scanner scan = new Scanner(System.in);

		// System.out.println("���� �ٸ� ���� 3���� �Է����ּ���.");

		for (int i = 0; i < 3; i++) {
			// System.out.print(i+1+"��° ���ڸ� �Է����ּ��� : ");
			user[i] = scan.nextInt();

			while (true) {
				if (!(user[i] >= 1 && user[i] <= 9)) {
					// System.out.println("�߸��� �Է��Դϴ�.");
					// System.out.print("�ٽ� �Է����ּ��� : ");
					user[i] = scan.nextInt();
				} else if (user[0] == user[1] || user[0] == user[2] || user[1] == user[2]) {
					// System.out.println("���� ���ڴ� �Է��ϸ� �ȵ˴ϴ�.");
					// System.out.print("�ٽ� �Է����ּ��� : ");
					user[i] = scan.nextInt();
				} else
					break;
			}
		}
	}

	// ���� ����
	public void output() {
		randomCpu();
		// while(true)
		// {
		System.out.println();
		// user 3�� �Է� ����

		// ���� ����
		strike = 0;
		ball = 0;

		for (int i = 0; i < 3; i++) {
			if (user[i] == cpu[i])
				strike++;
		}

		if (user[0] == cpu[1] || user[0] == cpu[2]) {
			ball++;
		}
		if (user[1] == cpu[0] || user[1] == cpu[2]) {
			ball++;
		}
		if (user[2] == cpu[0] || user[2] == cpu[1]) {
			ball++;
		}

		if (strike == 3) {
			// System.out.println("Ȩ���Դϴ�.");
			// break;
		} else if (strike == 0 && ball == 0) {
			// System.out.println("out�Դϴ�.");
		} else {
			// System.out.println("Strike :"+strike+" // "+"Ball : "+ball+"�Դϴ�.");
		}

		// }
	}
}

class Layout extends JFrame implements ActionListener {
	Game g = new Game();
	JTextField jf;
	Circle p2;
	int num1, num2, num3;

	public Layout() {
		g.output();
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());

		JPanel p1 = new JPanel();
		jf = new JTextField(
				"=== ���� >> cpu[0]=" + g.cpu[0] + " // cpu[1]=" + g.cpu[1] + " // cpu[2]=" + g.cpu[2] + " ===");
		p1.add(jf);
		ct.add(p1, BorderLayout.NORTH);

		p2 = new Circle();
		p2.setLayout(new FlowLayout());
		ct.add(p2, BorderLayout.CENTER);

		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(4, 2, 10, 10));
		for (int i = 1; i <= 8; i++) {
			if (i == 1) {
				p3.add(new JButton("���� 1"));
			} else if (i == 2) {
				p3.add(new JButton("��ư" + i));
			} else if (i == 3) {
				p3.add(new JButton("���� 2"));
			} else if (i == 4) {
				p3.add(new JButton("��ư" + i));
			} else if (i == 5) {
				p3.add(new JButton("���� 3"));
			} else if (i == 6) {
				p3.add(new JButton("��ư" + i));
			} else if (i == 7) {

			} else if (i == 8) {
				p3.add(new JButton("�Է�"));
			}

		}
		ct.add(p3, BorderLayout.SOUTH);

		setTitle("���ھ߱�����");
		setSize(800, 800);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

	}
}

class Circle extends JPanel {
	int select = -1;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (select == -1) {
			g.setColor(Color.RED);
			g.drawOval(150, 100, 80, 80);
			g.setColor(Color.YELLOW);
			g.drawOval(70, 190, 80, 80);
			g.setColor(Color.GREEN);
			g.drawOval(100, 300, 80, 80);
			g.setColor(Color.BLUE);
			g.drawOval(220, 190, 80, 80);
			g.setColor(Color.PINK);
			g.drawOval(210, 300, 80, 80);
		} else if (select == 0) {
			g.setColor(Color.RED);
			g.fillOval(150, 100, 80, 80);
			g.setColor(Color.YELLOW);
			g.drawOval(70, 190, 80, 80);
			g.setColor(Color.GREEN);
			g.drawOval(100, 300, 80, 80);
			g.setColor(Color.BLUE);
			g.drawOval(220, 190, 80, 80);
			g.setColor(Color.PINK);
			g.drawOval(210, 300, 80, 80);
		} else if (select == 1) {
			g.setColor(Color.RED);
			g.drawOval(150, 100, 80, 80);
			g.setColor(Color.YELLOW);
			g.fillOval(70, 190, 80, 80);
			g.setColor(Color.GREEN);
			g.drawOval(100, 300, 80, 80);
			g.setColor(Color.BLUE);
			g.drawOval(220, 190, 80, 80);
			g.setColor(Color.PINK);
			g.drawOval(210, 300, 80, 80);
		} else if (select == 2) {
			g.setColor(Color.RED);
			g.drawOval(150, 100, 80, 80);
			g.setColor(Color.YELLOW);
			g.drawOval(70, 190, 80, 80);
			g.setColor(Color.GREEN);
			g.drawOval(100, 300, 80, 80);
			g.setColor(Color.BLUE);
			g.fillOval(220, 190, 80, 80);
			g.setColor(Color.PINK);
			g.drawOval(210, 300, 80, 80);
		} else if (select == 3) {
			g.setColor(Color.RED);
			g.drawOval(150, 100, 80, 80);
			g.setColor(Color.YELLOW);
			g.drawOval(70, 190, 80, 80);
			g.setColor(Color.GREEN);
			g.fillOval(100, 300, 80, 80);
			g.setColor(Color.BLUE);
			g.drawOval(220, 190, 80, 80);
			g.setColor(Color.PINK);
			g.drawOval(210, 300, 80, 80);
		} else if (select == 4) {
			g.setColor(Color.RED);
			g.drawOval(150, 100, 80, 80);
			g.setColor(Color.YELLOW);
			g.drawOval(70, 190, 80, 80);
			g.setColor(Color.GREEN);
			g.drawOval(100, 300, 80, 80);
			g.setColor(Color.BLUE);
			g.drawOval(220, 190, 80, 80);
			g.setColor(Color.PINK);
			g.fillOval(210, 300, 80, 80);
		}
	}
}

public class Q55 {

	public static void main(String[] args) {
		new Layout();
	}

}
