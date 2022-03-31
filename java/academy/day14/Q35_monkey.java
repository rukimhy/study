package academy.day14;

import java.util.Random;

class Monkey {
	Fire fire_check;
	String color;

	void print() {
		if (fire_check != null) {
			System.out.println(color + " �����̰� ���� ������ �ֽ��ϴ�.");
		}
	}
}

class Fire {

}

public class Q35_monkey {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * ������ �Ҽ��� ������ ����
		 * ������ 5������ �ִ�. ���� ������, �����, �Ķ���, �ʷϻ�, ������
		 * �������� ���� �� �� �޴´�. �ϳ��� 0(����) 1(������) / �ϳ��� 1~5���� �� ����
		 * �����̴� �ð�������� �������ʰ�, ���� ��üȭ�Ѵ�.
		 * ���ι����� �� �������� ����Ѵ�.
		 * �����̴� ���� �ڱ����� ���� "XXX �����̰� ���� ������ �ֽ��ϴ�."�� ��µǾ��Ѵ�.
		 */

		Random r = new Random();
		int direction = r.nextInt(2);
		int count = r.nextInt(5) + 1;

		Fire fire = new Fire();

		Monkey[] monkey = new Monkey[5];
		for (int i = 0; i < 5; i++) {
			monkey[i] = new Monkey();
		}
		monkey[0].color = "������";
		monkey[1].color = "�����";
		monkey[2].color = "�Ķ���";
		monkey[3].color = "�ʷϻ�";
		monkey[4].color = "������";

		System.out.println("���Ⱚ : " + direction + " // �̵��� : " + count);

		if (direction == 1) {
			for (int i = 1; i <= count; i++) {
				if (i % 5 != 0) {
					monkey[i].fire_check = new Fire();

					monkey[i].print();
					monkey[i].fire_check = null;
				} else {
					monkey[0].fire_check = new Fire();
					monkey[0].print();
					monkey[0].fire_check = null;

				}
			}

		} else {
			for (int i = 4; i > 4 - count; i--) {
				monkey[i].fire_check = new Fire();
				monkey[i].print();
				monkey[i].fire_check = null;

			}
		}
	}
}
