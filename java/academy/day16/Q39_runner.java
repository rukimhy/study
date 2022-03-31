package academy.day16;

import java.util.Random;
import java.util.concurrent.TimeUnit;

class Runner {
	String country;
	int lane;
	int m;

	void print() {
		System.out.println(lane + "������ " + country + " ������ ���� " + m + "m �Դϴ�.");
	}

	void winner() {
		if (m >= 100) {
			System.out.println("��±��� " + country + "�Դϴ�!!!");
		}
	}
}

public class Q39_runner {

	public static void main(String[] args) {
		/*
		 * ���󼱼� 4���� �ִ�. �ѱ�, �߱�, �̱�, ���þ� ������ �ִ�.
		 * ���� �����̰�, 1�ϸ��� �������� 1~10m�� �̵��� �� �� �ִ�.
		 * 1������ - �ѱ�, 2������ - �߱�, 3������ - �̱�, 4������ - ���þ�
		 * �� �ϸ��� ���� ��Ȳ�� ���ܼ� �� ������ �̵��� �� ���� ����.
		 * �� �ϸ��� ����� �Ǿ��Ѵ�.
		 * ���� 100m ������� ������ ������ ������ ������ "��±� XXX�Դϴ�!" ����ϰ� ������
		 * �����Ѵ�.
		 * ���ÿ� 100m�� ������ ���� �� ū ������ ����Ѵ�.
		 */
		Random r = new Random();
		String[] country = new String[] { "�ѱ�", "�߱�", "�̱�", "���þ�" };
		int[] lane = new int[] { 1, 2, 3, 4 };

		Runner[] runner = new Runner[4];
		for (int i = 0; i < 4; i++) {
			runner[i] = new Runner();
			runner[i].country = country[i];
			runner[i].lane = lane[i];
			runner[i].m = 0;
		}

		int turn = 1;
		while (true) {
			int warning = r.nextInt(4);
			for (int i = 0; i < 4; i++) {
				if (i == warning)
					continue; // ����� ���� �� ������ �� �� ����.
				else {
					int randomMeter = r.nextInt(10) + 1;
					runner[i].m += randomMeter;
				}
			}
			System.out.println("-------" + turn + "��--------");
			for (int i = 0; i < 4; i++) {
				runner[i].print();
			}
			System.out.println("-------------------------");
			turn++;

			if (runner[0].m >= 100 || runner[1].m >= 100 || runner[2].m >= 100 || runner[3].m >= 100) {

				int winIndex = 0;
				for (int i = 1; i < 4; i++) // ���� �� �� �Ÿ��� �޷ȳ� Ȯ���Ѵ�.
				{
					if (runner[winIndex].m < runner[i].m) {
						winIndex = i;
					}
				}
				runner[winIndex].winner();

				break;
			}

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
