package academy.day20;
/* �θ� : �κ� / �ڽ� : ����, ����, �׸�, ���ο�, ��ũ
 * �θ�� 5�迭 �����. ��ü�� �����ؼ� �κ� �迭�� ä���.
 * 0~4 �������� �޾Ƽ� 0�̸� ����, 1�̸� ����, 2�� �׸�, 3�̸� ���ο�, 4�� ��ũ
 * �������� ��ü ä��ٺ��� �ߺ��� ��찡 �ִ�
 * ���� ���� �׸� ���ο� ��ũ ���� ������� ���� ���α׷� ����
 * �θ� �迭 ä�ﶧ���� 0~4 �ε��� �ȿ� � ��ü�� �ִ��� ���
 */

import java.util.Random;

class Robot {
}

class Red extends Robot {
}

class Blue extends Robot {
}

class Green extends Robot {
}

class Yellow extends Robot {
}

class Pink extends Robot {
}

public class Q44_powerRanger {

	public static void main(String[] args) {
		Random r = new Random();
		Robot[] robot = new Robot[5];

		while (true) {
			int redCount = 0;
			int blueCount = 0;
			int greenCount = 0;
			int yellowCount = 0;
			int pinkCount = 0;

			for (int i = 0; i < 5; i++) {
				int random = r.nextInt(5);
				if (random == 0) {
					robot[i] = new Red();
					redCount++;
				} else if (random == 1) {
					robot[i] = new Blue();
					blueCount++;
				} else if (random == 2) {
					robot[i] = new Green();
					greenCount++;
				} else if (random == 3) {
					robot[i] = new Yellow();
					yellowCount++;
				} else {
					robot[i] = new Pink();
					pinkCount++;
				}
			}

			for (int i = 0; i < 5; i++) {
				if (robot[i] instanceof Red) {
					System.out.print(i + "=���� // ");
				} else if (robot[i] instanceof Blue) {
					System.out.print(i + "=���� // ");
				} else if (robot[i] instanceof Green) {
					System.out.print(i + "=�׸� // ");
				} else if (robot[i] instanceof Yellow) {
					System.out.print(i + "=���ο� // ");
				} else {
					System.out.print(i + "=��ũ // ");
				}
			}
			System.out.println();

			if (redCount == 1 && blueCount == 1 && greenCount == 1 && yellowCount == 1 && pinkCount == 1) {
				System.out.println("��ü����");
				break;
			}
		}
	}

}
