package academy.day27;

import java.util.Random;

/* 2���� ����� �ְ� �� ����� 1�ϸ��� 1~20 �������� �޾Ƽ� ��Ż���� �����Ѵ�.
 * 100���� ������ ���� � ����� �̰���� ���
 * ��, �� ����� �����ư��鼭 ����Ǵ� ���� �ƴ϶� ���ÿ� 100���� ����Ǿ�� �Ѵ�.
 * ������ ���
 */

class Total {
	int total = 0;

	void sum(Random r) {
		total += r.nextInt(20) + 1;
	}

	int getTotal() {
		return total;
	}
}

class Human extends Thread {
	Total t;
	Random r;
	int total;

	Human(Total t, String name, Random r) {
		this.t = t;
		setName(name);
		this.r = r;
	}

	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println(getName() + "�� " + i + "��° ��");
			t.sum(r);
		}
		this.total = t.getTotal();
	}
}

public class Q51 {

	public static void main(String[] args) throws InterruptedException {
		Random r = new Random();

		Total t1 = new Total();
		Total t2 = new Total();

		Human h1 = new Human(t1, "���1", r);
		Human h2 = new Human(t2, "���2", r);

		h1.start();
		h2.start();

		h1.join();
		h2.join();

		System.out.println(h1.getName() + ":" + h1.total);
		System.out.println(h2.getName() + ":" + h2.total);

		if (h1.total > h2.total) {
			System.out.println(h1.getName() + "�� �̰���ϴ�.");
		} else {
			System.out.println(h2.getName() + "�� �̰���ϴ�.");
		}
	}

}
